package com.snapchat.snapmod;

import static com.snapchat.snapmod.Shared.SNAP_PACKAGE;
import static com.snapchat.snapmod.Shared.USE_NEW_STORY_METHOD;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import com.snapchat.snapmod.mappings.CalendarDate;
import com.snapchat.snapmod.mappings.ChatMediaHandler;
import com.snapchat.snapmod.mappings.ChatModelAudioNote;
import com.snapchat.snapmod.mappings.ChatModelBase;
import com.snapchat.snapmod.mappings.ChatModelSavedSnap;
import com.snapchat.snapmod.mappings.ContentType;
import com.snapchat.snapmod.mappings.EncryptionAlgorithm;
import com.snapchat.snapmod.mappings.FooterInfoItem;
import com.snapchat.snapmod.mappings.FriendActionRequest;
import com.snapchat.snapmod.mappings.FriendProfilePageData;
import com.snapchat.snapmod.mappings.FriendPublicProfileTile;
import com.snapchat.snapmod.mappings.GlobalErrorHandler;
import com.snapchat.snapmod.mappings.LiveSnapMedia;
import com.snapchat.snapmod.mappings.LocationMessage;
import com.snapchat.snapmod.mappings.MediaPackage;
import com.snapchat.snapmod.mappings.MediaType;
import com.snapchat.snapmod.mappings.MessageSenderCrossroad;
import com.snapchat.snapmod.mappings.MessageUpdate;
import com.snapchat.snapmod.mappings.OperaActionMenuOptionViewModel;
import com.snapchat.snapmod.mappings.OperaContextActions;
import com.snapchat.snapmod.mappings.OperaMediaInfo;
import com.snapchat.snapmod.mappings.ParameterPackage;
import com.snapchat.snapmod.mappings.PublicUserReportParams;
import com.snapchat.snapmod.mappings.RxObserver;
import com.snapchat.snapmod.mappings.SaveType;
import com.snapchat.snapmod.mappings.StoryReportParams;
import com.snapchat.snapmod.mappings.UploadResult;
import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SnapHooks implements IXposedHookLoadPackage {

    public static final String MAIN_ACTIVITY = "com.snap.mushroom.MainActivity";
    public static final String CONVERSATION_MANAGER_PROXY = "com.snapchat.client.messaging.ConversationManager$CppProxy";
    public static final String LOCAL_MESSAGE_CONTENT = "com.snapchat.client.messaging.LocalMessageContent";
    public static final String SAVE_POLICY = "com.snapchat.client.messaging.SavePolicy";
    public static final String NETWORK_API = "com.snapchat.client.network_api.NetworkApi$CppProxy";

    private static final String PROFILE_PICTURE_RESOLUTION_PATTERN = "0,\\d+_";

    private static volatile String lastMediaId;
    private static String lastPublicProfilePictureUrl;

    private static Prevent prevent;

    private Context appContext;
    private ChatMediaHandler chatMediaResolver;
    private final Map<Integer, Object> chatMediaMap = new HashMap<>();

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(SNAP_PACKAGE)) {
            String buildPath = XposedHelpers.getStaticIntField(XposedHelpers.findClass(SNAP_PACKAGE + ".BuildConfig", lpparam.classLoader), "VERSION_CODE") + ".json";
            File mappingsFile = new File(Shared.SNAPMOD_MAPPINGS_DIR, buildPath);
            if (!mappingsFile.exists()) {
                XposedBridge.log("No mappings found at " + mappingsFile + ".");
                return;
            }

            try (InputStream in = new FileInputStream(mappingsFile)) {
                Mappings.loadMappings(lpparam.classLoader, in);
            }

            prevent = new Prevent();

            Class<?> MainActivity = XposedHelpers.findClass(MAIN_ACTIVITY, lpparam.classLoader);

            XposedBridge.hookAllMethods(MainActivity, "attachBaseContext", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    appContext = (Context) param.thisObject;
                    Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
                        XposedBridge.log("Exception on thread " + thread.getName() + ", " + thread.getId());
                        XposedBridge.log(throwable);
                    });
                }
            });

            XposedBridge.hookAllMethods(DevicePolicyManager.class, "getCameraDisabled", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("disable_camera")) {
                        param.setResult(true);
                    }
                }
            });

            Class<?> ConversationManager = XposedHelpers.findClass(CONVERSATION_MANAGER_PROXY, lpparam.classLoader);
            Class<?> LocalMessageContent = XposedHelpers.findClass(LOCAL_MESSAGE_CONTENT, lpparam.classLoader);
            Class<?> SavePolicy = XposedHelpers.findClass(SAVE_POLICY, lpparam.classLoader);
            Class<?> NetworkApi = XposedHelpers.findClass(NETWORK_API, lpparam.classLoader);

            XposedBridge.hookAllMethods(ConversationManager, "sendMessageWithContent", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Object contentType = XposedHelpers.callMethod(param.args[1], "getContentType");
                    prevent.prevent(param, "hide_screenshot", contentType, ContentType.STATUS_CONVERSATION_CAPTURE_RECORD(), ContentType.STATUS_CONVERSATION_CAPTURE_SCREENSHOT());
                    prevent.prevent(param, "hide_save_gallery", contentType, ContentType.STATUS_SAVE_TO_CAMERA_ROLL());
                }
            });

            XposedBridge.hookAllMethods(ConversationManager, "updateMessage", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Object update = param.args[2];
                    prevent.prevent(param, "hide_read", update, MessageUpdate.READ());
                    prevent.prevent(param, "hide_save", update, MessageUpdate.SAVE(), MessageUpdate.UNSAVE());
                    prevent.prevent(param, "hide_screenshot", update, MessageUpdate.SCREENSHOT(), MessageUpdate.SCREEN_RECORD());
                    prevent.prevent(param, "hide_replay", update, MessageUpdate.REPLAY());
                    prevent.prevent(param, "dont_release", update, MessageUpdate.RELEASE());
                }
            });

            XposedBridge.hookAllMethods(ConversationManager, "displayedMessages", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("hide_read")) {
                        XposedBridge.log("Prevented displayedMessages call (hide_read).");
                        param.setResult(null);
                    }
                }
            });

            XposedBridge.hookAllMethods(ConversationManager, "enterConversation", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("hide_enter_conversation")) {
                        XposedBridge.log("Prevented enterConversation call (hide_enter_conversation).");
                        param.setResult(null);
                    }
                }
            });

            XposedBridge.hookAllMethods(ConversationManager, "exitConversation", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("hide_exit_conversation")) {
                        XposedBridge.log("Prevented exitConversation call (hide_exit_conversation).");
                        param.setResult(null);
                    }
                }
            });

            XposedBridge.hookAllMethods(ConversationManager, "sendTypingNotification", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("hide_typing")) {
                        XposedBridge.log("Prevented sendTypingNotification call (hide_typing).");
                        param.setResult(null);
                    }
                }
            });

            XposedBridge.hookAllMethods(LocalMessageContent, "getSavePolicy", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("save_any")) {
                        XposedBridge.log("Modified getSavePolicy (save_any).");
                        param.setResult(XposedHelpers.callStaticMethod(SavePolicy, "valueOf", "LIFETIME"));
                    }
                }
            });

            XC_MethodHook networkHook = new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("log_network_requests")) {
                        XposedBridge.log(param.args[0].toString());
                    }
                }
            };

            XposedBridge.hookAllMethods(NetworkApi, "submit", networkHook);
            XposedBridge.hookAllMethods(NetworkApi, "submitToNetworkManagerDirectly", networkHook);

            Mappings.hookConstructors("ChatMediaHandler", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    chatMediaResolver = ChatMediaHandler.wrap(param.thisObject);
                }
            });

            Mappings.hook("UploadResultWaiter", "apply", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    UploadResult result = UploadResult.wrap(param.getResult());
                    MediaPackage mediaPackage = result.getMediaPackage();
                    lastMediaId = mediaPackage.getMediaId();
                    XposedBridge.log("Media uploaded with ID: " + lastMediaId);
                }
            });

            Mappings.hook("MessageSenderCrossroad", "apply", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    boolean pref = prevent.isEnabled("override_snap");
                    XposedBridge.log("Snap message crossroad hit (override_snap=" + pref + ").");
                    if (pref) {
                        MessageSenderCrossroad $this = MessageSenderCrossroad.wrap(param.thisObject);
                        Object media = $this.getMedia();
                        XposedBridge.log("Media class: " + media.getClass().getName());
                        if (Mappings.isInstance("GallerySnapMedia", media)) {
                            LiveSnapMedia snap = new LiveSnapMedia();
                            double timer = Double.parseDouble(prevent.getPreferences().getString("override_snap_timer", "0"));
                            XposedBridge.log("Message contains media from gallery. Replacing with snap (mediaId=" + lastMediaId + ").");
                            snap.setMediaId(lastMediaId);

                            if (prevent.isEnabled("enable_snap_type_override")) {
                                String overrideType = prevent.getPreferences().getString("snap_type_override", "IMAGE");
                                XposedBridge.log("Overriding snap type to " + overrideType);
                                snap.setMediaType(MediaType.valueOf(overrideType));
                            } else {
                                snap.setMediaType(MediaType.IMAGE());
                            }

                            ParameterPackage paramPackage = new ParameterPackage("", "");
                            paramPackage.setIsInfiniteDuration(timer == 0d);
                            paramPackage.setTimerOrDurationSeconds(timer);
                            snap.setParameterPackage(paramPackage);
                            $this.setMedia(snap);

                            XposedBridge.log("Replaced gallery with snap successfully.");
                        }
                    }
                }
            });

            Mappings.hook("ChatActionHelper", "canSave", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("allow_save_snaps")) {
                        XposedBridge.log("Overriding ChatActionHelper.canSave on " + param.args[0].getClass().getName());
                        param.setResult(true);
                    }
                }
            });

            Mappings.hook("ChatModelBase", "canSave", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("allow_save_snaps")) {
                        XposedBridge.log("Overriding canSave on " + param.thisObject.getClass().getName());
                        param.setResult(true);
                    }
                }
            });

            Mappings.hook("ChatModelBase", "getSaveType", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("getSaveType on " + param.thisObject.getClass().getName());
                    XposedBridge.log("ChatModelLiveSnap: " + Mappings.isInstance("ChatModelLiveSnap", param.thisObject));
                    if (prevent.isEnabled("allow_save_snaps")
                            && (Mappings.isInstance("ChatModelLiveSnap", param.thisObject)
                            || Mappings.isInstance("ChatModelAudioNote", param.thisObject))) {
                        XposedBridge.log("Overriding getSaveType on " + param.thisObject.getClass().getName());
                        param.setResult(SaveType.SNAPCHAT_ALBUM().instance);
                    }
                }
            });

            Mappings.hookConstructors("ChatModelLiveSnap", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("allow_save_snaps")) {
                        int hashCode = param.thisObject.hashCode();
                        XposedBridge.log("Mapping live snap chat model to media (hashCode=" + hashCode + ").");
                        chatMediaMap.put(hashCode, param.args[6]);
                    }
                }
            });

            Mappings.hook("FriendProfileTransformer", "apply", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("more_profile_info")) {
                        FriendProfilePageData data = FriendProfilePageData.wrap(param.args[0]);
                        Date friendDate = new Date(Math.max(data.getAddedTimestamp(), data.getReverseAddedTimestamp()));
                        CalendarDate birthday = data.getBirthday();
                        if (birthday.isNull()) {
                            birthday = new CalendarDate(13, -1);
                        }
                        String info = "Friends with " +
                                data.getDisplayName() +
                                " since " +
                                new SimpleDateFormat("dd MMMM yyyy").format(friendDate) +
                                ".\n" +
                                data.getDisplayName() +
                                "'s birthday is " +
                                birthday.getDay() +
                                " " +
                                Shared.MONTHS[birthday.getMonth() - 1] +
                                "\nFriendship: " +
                                data.getFriendLinkType().instance +
                                "\nAdded by: " +
                                data.getAddSourceTypeForNonFriend().instance;
                        param.setResult(Collections.singletonList(new FooterInfoItem(info, 0).instance));
                    }
                }
            });

            Mappings.hook("StoryContextActionHandler", "apply", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("allow_public_profile")) {
                        param.args[1] = Boolean.TRUE;
                        XposedBridge.log("Overriding public profile condition.");
                    }
                }
            });

            Mappings.hook("SaveToCameraRollActionHandler", "exportMedia", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("allow_save_snaps")) {
                        if (Mappings.isInstance("ChatModelLiveSnap", param.args[1])) {
                            int hashCode = param.args[1].hashCode();
                            XposedBridge.log("Converting live snap chat model to saved snap (hashCode=" + hashCode + ").");
                            LiveSnapMedia media = LiveSnapMedia.wrap(chatMediaMap.get(hashCode));
                            ChatModelBase base = ChatModelBase.wrap(param.args[1]);
                            param.args[1] = new ChatModelSavedSnap(base.getContext(), base.getMessageData(), base.getSenderId(), new HashMap(), true, base.getReactionsViewModel(), true, 0, 0, media, null, base.getStatus(), true).instance;
                            XposedBridge.log("Converted successfully.");
                        } else if (Mappings.isInstance("ChatModelAudioNote", param.args[1])) {
                            Toast.makeText(appContext, "Downloading audio note...", Toast.LENGTH_SHORT).show();
                            ChatModelBase base = ChatModelBase.wrap(param.args[1]);
                            ChatModelAudioNote audio = ChatModelAudioNote.wrap(param.args[1]);
                            File dest = new File(Shared.SNAPMOD_MEDIA_DIR, Shared.SNAPMOD_MEDIA_PREFIX + base.getSenderId() + "_" + System.currentTimeMillis() + ".aac");
                            Object observerProxy = Proxy.newProxyInstance(lpparam.classLoader, new Class[]{Mappings.getClass("RxObserver")}, new UriResolverSubscriber.MediaUriDownloader(dest));
                            chatMediaResolver.resolve(audio.getUri(), new HashSet(), true, new HashSet()).subscribe(RxObserver.wrap(observerProxy));
                            param.setResult(null);
                        }
                    }
                }
            });

            Mappings.hook("GlobalErrorHandler", "accept", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("allow_download_stories")
                            && GlobalErrorHandler.wrap(param.thisObject).getErrorCode() == GlobalErrorHandler.REPORT_ERROR_CASE) {
                        XposedBridge.log("Ignoring report error.");
                        param.setResult(null);
                    }
                }
            });

            Mappings.hook("BitmojiUriHandler", "handle", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("disable_bitmojis")) {
                        XposedBridge.log("Bypassing bitmoji loading...");
                        param.setResult(null);
                    }
                }
            });

            Mappings.hook("FriendActionClient", "sendFriendAction", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("enable_friend_override")) {
                        FriendActionRequest request = FriendActionRequest.wrap(param.args[0]);
                        if (request.getAction().equals("add")) {
                            String addMethod = prevent.getPreferences().getString("friend_override_value", "ADDED_BY_USERNAME");
                            request.setAddedBy(addMethod);
                            XposedBridge.log("Friend add method overriden (changed " + request.getAddedBy() + " to " + addMethod + ").");
                        }
                    }
                }
            });

            Mappings.hookConstructors("MemoriesPickerVideoDurationConfig", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("bypass_video_length_restrictions")) {
                        XposedBridge.log("Bypassing video length restrictions (was " + param.args[0] + ").");
                        param.args[0] = Long.MAX_VALUE;
                    }
                }
            });

            Mappings.hook("LocationMessageBuilder", "transform", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("location_share_override")) {
                        double lat = Double.parseDouble(prevent.getPreferences().getString("location_share_lat", "0"));
                        double $long = Double.parseDouble(prevent.getPreferences().getString("location_share_long", "0"));
                        LocationMessage loc = LocationMessage.wrap(param.args[0]);
                        loc.setLatitude(lat);
                        loc.setLongitude($long);
                        XposedBridge.log("Location share lat/long overwritten lat=" + lat + ", long=" + $long);
                    }
                }
            });

            Mappings.hookConstructors("FriendPublicProfileTile", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    lastPublicProfilePictureUrl = FriendPublicProfileTile.wrap(param.thisObject).getProfilePictureUrl();
                }
            });

            Mappings.hook("InAppReportManagerImpl","handle", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    if (prevent.isEnabled("allow_download_public_dp") && lastPublicProfilePictureUrl != null && Mappings.isInstance("PublicUserReportParams", param.args[0])) {
                        String resolution = prevent.getPreferences().getString("public_dp_resolution", "500");
                        double resDouble = Double.valueOf(resolution);
                        if (resDouble < 1 || resDouble > 5000) {
                            resDouble = 500;
                        }
                        resolution = String.valueOf((int)resDouble);
                        String url = lastPublicProfilePictureUrl.replaceAll(PROFILE_PICTURE_RESOLUTION_PATTERN, "0," + resolution + "_");
                        PublicUserReportParams params = PublicUserReportParams.wrap(param.args[0]);
                        try {
                            new Thread(() -> downloadFile(params.getUsername() + "_profile_" + System.currentTimeMillis(), url)).start();
                        } catch (Exception e) {
                            XposedBridge.log(e);
                        }

                        param.setResult(null);
                    }
                }
            });

            if (prevent.isEnabled("allow_download_stories")) {
                Class<?> clsOperaContextActions = Mappings.getClass("OperaContextActions");
                Field reportAction = null;
                Field saveAction = null;
                for (Field f : clsOperaContextActions.getDeclaredFields()) {
                    OperaActionMenuOptionViewModel model = OperaActionMenuOptionViewModel.wrap(f.get(null));
                    if (model.isNotNull()) {
                        String eventName = model.getEventName();
                        if (eventName == null) {
                            eventName = model.getActionMenuId().toString();
                        }
                        if (eventName.equals(OperaContextActions.REPORT_EVENT_NAME)) {
                            reportAction = f;
                            XposedBridge.log("Found report action @ " + reportAction.getName());
                        } else if (eventName.equals(OperaContextActions.SAVE_EVENT_NAME)) {
                            saveAction = f;
                            XposedBridge.log("Found save action @ " + saveAction.getName());
                        }
                    }
                }

                if (reportAction != null && saveAction != null) {
                    OperaActionMenuOptionViewModel saveActionModel = OperaActionMenuOptionViewModel.wrap(saveAction.get(null));
                    OperaActionMenuOptionViewModel reportActionModel = OperaActionMenuOptionViewModel.wrap(reportAction.get(null));
                    reportActionModel.setIconResource(saveActionModel.getIconResource());
                    reportActionModel.setStringResource(saveActionModel.getStringResource());
                    reportActionModel.setTextColorResource(saveActionModel.getTextColorResource());
                    reportActionModel.setLoading(false);
                    XposedBridge.log("Replaced report with save button.");
                }

                if (USE_NEW_STORY_METHOD) {
                    StoryHelper.init();

                    XC_MethodHook downloadHook = new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            XposedBridge.log("Story report hook.");
                            if (prevent.isEnabled("allow_download_stories")) {
                                OperaMediaInfo info = StoryHelper.getMediaInfo(param.args[0]);
                                if (info != null && info.isNotNull()) {
                                    //Toast.makeText(appContext, "Downloading story snap...", Toast.LENGTH_SHORT).show();

                                    XposedBridge.log("Starting downloader thread...");
                                    try {
                                        new Thread(() -> downloadStorySnap(String.valueOf(System.nanoTime()), info)).start();
                                    } catch (Exception e) {
                                        XposedBridge.log(e);
                                    }
                                } else {
                                    XposedBridge.log("Null media info for story download.");
                                }

                                param.setResult(null);
                            }
                        }
                    };

                    Mappings.hook("PublicUserStoryInAppReportClient", "report", downloadHook);
                    Mappings.hook("FriendStoryInAppReportClient", "report", downloadHook);
                    Mappings.hook("PublisherStoryInAppReportClient", "report", downloadHook);
                    Mappings.hook("DynamicStoryInAppReportClient", "report", downloadHook);
                    Mappings.hook("AdInAppReportClient", "report", downloadHook);
                    Mappings.hook("ChatMediaInAppReportClient", "report", downloadHook);
                    Mappings.hook("TopicSnapInAppReportClient", "report", downloadHook);
                    Mappings.hook("DirectSnapInAppReportClient", "report", downloadHook);
                } else {
                    Mappings.hook("ReportHandler", "apply", new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            if (prevent.isEnabled("allow_download_stories")) {
                                Toast.makeText(appContext, "Downloading story snap...", Toast.LENGTH_SHORT).show();

                                XposedBridge.log("Starting downloader thread...");
                                try {
                                    StoryReportParams params = StoryReportParams.wrap(param.args[0]);
                                    new Thread(() -> downloadStorySnap(params)).start();
                                } catch (Exception e) {
                                    XposedBridge.log(e);
                                }

                                param.setResult(null);
                            }
                        }
                    });
                }
            }

            Experiments.hookAll();
        }
    }

    private void downloadStorySnap(StoryReportParams params) {
        downloadStorySnap(params.getSnapId(), params.getMediaInfo());
    }

    private void downloadStorySnap(String filePrefix, OperaMediaInfo media) {
        try {
            InputStream stream = new URL(media.getUri()).openStream();

            EncryptionAlgorithm enc = media.getEncryption();
            if (enc.isNotNull()) {
                XposedBridge.log("Stream is encrypted - applying decryption.");
                stream = enc.decryptStream(stream);
            }

            boolean video = media.getStreamingMethod().isNotNull() || (media.getUri() != null && media.getUri().endsWith("mp4"));

            File dest = new File(Shared.SNAPMOD_MEDIA_DIR, Shared.SNAPMOD_MEDIA_PREFIX + filePrefix + (video ? ".mp4" : ".jpg"));
            dest.getParentFile().mkdirs();

            XposedBridge.log("Downloading snap media to path " + dest);
            Streams.copy(stream, dest);

            stream.close();
        } catch (Exception e) {
            XposedBridge.log("Error while downloading story snap.");
            XposedBridge.log(e);
        }
    }

    private void downloadFile(String filePrefix, String url) {
        try {
            InputStream stream = new URL(url).openStream();
            File dest = new File(Shared.SNAPMOD_MEDIA_DIR, Shared.SNAPMOD_MEDIA_PREFIX + filePrefix + ".jpg");
            dest.getParentFile().mkdirs();

            XposedBridge.log("Downloading file to " + dest);
            Streams.copy(stream, dest);

            stream.close();
        } catch (Exception e) {
            XposedBridge.log("Error while downloading file.");
            XposedBridge.log(e);
        }
    }

    static class Prevent {

        private final File configFile = new File(Shared.SNAPMOD_CONFIG);

        private XSharedPreferences prefs;
        private long lastLoadTime = 0L;

        public XSharedPreferences getPreferences() {
            if (configFile.lastModified() > lastLoadTime || prefs == null) {
                XposedBridge.log("Loading preferences from " + configFile + " (exists=" + configFile.exists() + ").");
                prefs = new XSharedPreferences(configFile);
                lastLoadTime = System.currentTimeMillis();
                XposedBridge.log("Loaded preferences.");
            }
            return prefs;
        }

        public boolean isEnabled(String pref) {
            return getPreferences().getBoolean(pref, false);
        }

        public void prevent(XC_MethodHook.MethodHookParam param, String pref, Object enumObj, Object... enumVals) {
            boolean prefVal = isEnabled(pref);
            XposedBridge.log("Preference " + pref + "=" + prefVal + ".");
            if (prefVal) {
                XposedBridge.log("Ordinal " + enumObj + "=" + enumObj + ", compare to " + Arrays.toString(enumVals));
                for (Object value : enumVals) {
                    if (value instanceof MappedObject) {
                        value = ((MappedObject) value).instance;
                    }
                    if (enumObj.equals(value)) {
                        XposedBridge.log("Prevented method call (" + pref + "), " + enumObj + "=" + value + ".");
                        param.setResult(null);
                        break;
                    }
                }
            }
        }
    }
}
