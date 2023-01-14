package com.scalar.design.lld.tinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author t0k02w6 on 04/01/23
 * @project scalar-ds
 */
public class System {
  private List<User> users;
  private Map<String, List<Match>> matches;
  private Map<String, Swipe> leftSwipe;
  private Map<String, Swipe> rightSwipe;
  private Map<String, List<User>> suggestions;

  public System() {

  }


  public List<User> recommend(User user) {
    List<User> users = suggestions.get(user.getId())
        .stream()
        .limit(5).collect(Collectors.toList());

    suggestions.get(user.getId()).subList(0, 5).clear();
    return users;
  }

  public void changeRadius(User user, int radius) {
    user.changeRadius(radius);
    List<User> newSuggestions = new ArrayList<>();
    for(int i = 0; i < users.size(); i++) {
      if(leftSwipe.get(user.getId()).containsUser(users.get(i)) ||
          rightSwipe.get(user.getId()).containsUser(users.get(i))) {
        continue;
      }
      if((users.get(i).getLocation() - user.getLocation()) < radius) {
        newSuggestions.add(users.get(i));
      }
    }
    suggestions.replace(user.getId(), newSuggestions);
  }

  public void swipeRight(User a, User b) {
    if(!rightSwipe.containsKey(a.getId())) {
      rightSwipe.put(a.getId(), new Swipe());
    }
    rightSwipe.get(a.getId()).addToSwipe(b);
    if(rightSwipe.get(b.getId()).containsUser(a)) {
      Match match = new Match(a, b);
      matches.get(a.getId()).add(match);
      matches.get(b.getId()).add(match);
    }
  }

  public void swipeLeft(User a, User b) {
    if(!leftSwipe.containsKey(a.getId())) {
      leftSwipe.put(a.getId(), new Swipe());
    }
    leftSwipe.get(a.getId()).addToSwipe(b);
  }
}
