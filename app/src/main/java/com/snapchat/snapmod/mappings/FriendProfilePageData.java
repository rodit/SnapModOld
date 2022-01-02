package com.snapchat.snapmod.mappings;

import com.util.mappings.MappedObject;
import com.util.mappings.Mappings;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;

public class FriendProfilePageData extends MappedObject {
  public FriendProfilePageData() {
    this(new Object[0]);
  }

  public FriendProfilePageData(Object instance) {
    super(Mappings.get("FriendProfilePageData"), instance);
  }

  public FriendProfilePageData(Object[] args) {
    super(Mappings.get("FriendProfilePageData"), args);
  }

  public String toString() {
    return (String) call("toString", new Object[0]);
  }

  public Object getUsername() {
    return (Object) get("username");
  }

  public void setUsername(Object value) {
    set("username", value);
  }

  public String getBitmojiSceneId() {
    return (java.lang.String) get("bitmojiSceneId");
  }

  public void setBitmojiSceneId(String value) {
    set("bitmojiSceneId", value);
  }

  public Long getScore() {
    return (java.lang.Long) get("score");
  }

  public void setScore(Long value) {
    set("score", value);
  }

  public FriendAddMethod getAddSourceTypeForNonFriend() {
    return FriendAddMethod.wrap(get("addSourceTypeForNonFriend"));
  }

  public void setAddSourceTypeForNonFriend(FriendAddMethod value) {
    set("addSourceTypeForNonFriend", value);
  }

  public String getBitmojiAvatarId() {
    return (java.lang.String) get("bitmojiAvatarId");
  }

  public void setBitmojiAvatarId(String value) {
    set("bitmojiAvatarId", value);
  }

  public Long getStoryRowId() {
    return (java.lang.Long) get("storyRowId");
  }

  public void setStoryRowId(Long value) {
    set("storyRowId", value);
  }

  public long getDataId() {
    return (long) get("dataId");
  }

  public void setDataId(long value) {
    set("dataId", value);
  }

  public String getBitmojiBackgroundId() {
    return (java.lang.String) get("bitmojiBackgroundId");
  }

  public void setBitmojiBackgroundId(String value) {
    set("bitmojiBackgroundId", value);
  }

  public Long getStoryLatestTimestamp() {
    return (java.lang.Long) get("storyLatestTimestamp");
  }

  public void setStoryLatestTimestamp(Long value) {
    set("storyLatestTimestamp", value);
  }

  public Boolean getStoryViewed() {
    return (java.lang.Boolean) get("storyViewed");
  }

  public void setStoryViewed(Boolean value) {
    set("storyViewed", value);
  }

  public Long getAddedTimestamp() {
    return (java.lang.Long) get("addedTimestamp");
  }

  public void setAddedTimestamp(Long value) {
    set("addedTimestamp", value);
  }

  public String getUserId() {
    return (java.lang.String) get("userId");
  }

  public void setUserId(String value) {
    set("userId", value);
  }

  public CalendarDate getBirthday() {
    return CalendarDate.wrap(get("birthday"));
  }

  public void setBirthday(CalendarDate value) {
    set("birthday", value);
  }

  public String getDisplayInteractionType() {
    return (java.lang.String) get("displayInteractionType");
  }

  public void setDisplayInteractionType(String value) {
    set("displayInteractionType", value);
  }

  public Long getExpirationTimestamp() {
    return (java.lang.Long) get("expirationTimestamp");
  }

  public void setExpirationTimestamp(Long value) {
    set("expirationTimestamp", value);
  }

  public String getDisplayName() {
    return (java.lang.String) get("displayName");
  }

  public void setDisplayName(String value) {
    set("displayName", value);
  }

  public Long getReverseAddedTimestamp() {
    return (java.lang.Long) get("reverseAddedTimestamp");
  }

  public void setReverseAddedTimestamp(Long value) {
    set("reverseAddedTimestamp", value);
  }

  public boolean getStoryMuted() {
    return (boolean) get("storyMuted");
  }

  public void setStoryMuted(boolean value) {
    set("storyMuted", value);
  }

  public String getServerDisplayName() {
    return (java.lang.String) get("serverDisplayName");
  }

  public void setServerDisplayName(String value) {
    set("serverDisplayName", value);
  }

  public FriendLinkType getFriendLinkType() {
    return FriendLinkType.wrap(get("friendLinkType"));
  }

  public void setFriendLinkType(FriendLinkType value) {
    set("friendLinkType", value);
  }

  public String getBitmojiSelfieId() {
    return (java.lang.String) get("bitmojiSelfieId");
  }

  public void setBitmojiSelfieId(String value) {
    set("bitmojiSelfieId", value);
  }

  public Boolean getStoryNotificationsEnabled() {
    return (java.lang.Boolean) get("storyNotificationsEnabled");
  }

  public void setStoryNotificationsEnabled(Boolean value) {
    set("storyNotificationsEnabled", value);
  }

  public static FriendProfilePageData wrap(Object instance) {
    return new FriendProfilePageData(instance);
  }
}
