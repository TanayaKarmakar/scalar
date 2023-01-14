package com.scalar.design.lld.tinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 04/01/23
 * @project scalar-ds
 */
public class Swipe {
  private Map<String, User> userSwipe;


  public Swipe() {
    userSwipe = new HashMap<>();
  }

  public void addToSwipe(User user) {
    userSwipe.put(user.getId(), user);
  }

  public boolean containsUser(User user) {
    return userSwipe.containsKey(user.getId());
  }



}
