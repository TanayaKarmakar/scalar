package com.scalar.design.revision.observer;

import com.scalar.design.revision.observer.impl.User;

/**
 * @author t0k02w6 on 21/05/23
 * @project scalar-ds
 */
public class ObserverTest {
  public static void main(String[] args) {
    Group group = new Group();
    User user1 = new User(1);
    User user2 = new User(2);
    User user3 = new User(3);

    group.subscribe(user1);
    group.subscribe(user2);
    group.subscribe(user3);

    group.notify("Design pattern is good");

    group.remove(user2);

    group.notify("Design Pattern is very very good");
  }
}
