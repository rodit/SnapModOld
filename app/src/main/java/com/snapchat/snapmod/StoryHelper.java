package com.snapchat.snapmod;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.snapchat.snapmod.mappings.OperaMediaInfo;
import com.snapchat.snapmod.mappings.StoryMedia;
import com.util.mappings.Mappings;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.robv.android.xposed.XposedBridge;

public class StoryHelper {

    private static final HashSet<String> STORY_MEDIA_KEY_NAMES = new HashSet<String>();
    private static final List<Object> STORY_MEDIA_KEYS = new ArrayList<>();
    private static Field MAP_FIELD = null;

    static {
        STORY_MEDIA_KEY_NAMES.add("overlay_image_media_info");
        STORY_MEDIA_KEY_NAMES.add("video_media_info");
        STORY_MEDIA_KEY_NAMES.add("image_media_info");
    }

    public static void init() {
        try {
            String operaMediaInfoName = Mappings.get("OperaMediaInfo").getDexClassName();
            XposedBridge.log("Initializing story helper: OperaMediaInfo: " + operaMediaInfoName);
            Field[] fields = Mappings.getClass("StoryMedia").getFields();
            Class<?> keyClass = null;
            Field keyNameField = null;
            for (Field field : fields) {
                if (MAP_FIELD == null && field.getType() == Map.class) {
                    MAP_FIELD = field;
                    continue;
                }

                Type genericType = field.getGenericType();
                if (genericType.toString().contains("<" + operaMediaInfoName + ">")) {
                    if (keyClass == null) {
                        keyClass = field.getType();
                        keyNameField = Arrays.stream(keyClass.getFields()).filter(f -> f.getType() == String.class).findFirst().get();
                        XposedBridge.log("Found keyClass " + keyClass.getName() + ", nameField=" + keyNameField);
                    }

                    Object key = field.get(null);
                    String keyName = (String) keyNameField.get(key);
                    if (STORY_MEDIA_KEY_NAMES.contains(keyName)) {
                        STORY_MEDIA_KEYS.add(key);
                        XposedBridge.log("Found story media key field: " + field.getName() + ", key=" + keyName);
                    }
                }
            }
        } catch (Exception e) {
            XposedBridge.log("Error while initializing story helper.");
            XposedBridge.log(e);
        }
    }

    public static OperaMediaInfo getMediaInfo(Object media) {
        try {
            Map<?, ?> map = (Map<?, ?>) MAP_FIELD.get(media);
            for (Object key : STORY_MEDIA_KEYS) {
                Object val = map.get(key);
                if (val != null) {
                    return OperaMediaInfo.wrap(val);
                }
            }
        } catch (Exception e) {
            XposedBridge.log("Error getting media info for " + media + ".");
        }
        return null;
    }
}
