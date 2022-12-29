package com.scalar.design.observer.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 24/12/22
 * @project scalar-ds
 */
public abstract class Publisher {
  protected List<Observer> observers = new ArrayList<>();

  public void publish() {
    observers.forEach(Observer::consume);
  }

  public void subscribe(Observer observer) {
    observers.add(observer);
  }

  public void unsubscribe(Observer observer) {
    observers.remove(observer);
  }
}
