package com.scalar.design.lld.tinder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 04/01/23
 * @project scalar-ds
 */
public class Match {
  private String id;
  private User a;
  private User b;
  private List<Chat> chats;

  public Match(User a, User b) {
    this.a = a;
    this.b = b;
    this.chats = new ArrayList<>();
  }

  public User getA() {
    return a;
  }

  public User getB() {
    return b;
  }

  public void addChat(Chat chat) {
    chats.add(chat);
  }
}
