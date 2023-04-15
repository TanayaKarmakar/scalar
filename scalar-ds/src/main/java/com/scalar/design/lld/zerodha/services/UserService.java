package com.scalar.design.lld.zerodha.services;

import com.scalar.design.lld.zerodha.models.User;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 15/04/23
 * @project scalar-ds
 */
public class UserService {
  private static Map<String, User> users;

  static {
    users = new HashMap<>();
  }

  public static void addUser(String userId, User user) {
    users.put(userId, user);
  }

  public static User getUser(String userId) {
    return users.get(userId);
  }
}
