package org.ez18n.sample;

public class PostCard {

  private final Messages messages;

  public PostCard(Messages resources) {
    this.messages = resources;
  }

  public String getText() {
    return messages.loveMeTender();
  }

  public String getLoveText(String name) {
    return messages.doYouLove(name);
  }
}
