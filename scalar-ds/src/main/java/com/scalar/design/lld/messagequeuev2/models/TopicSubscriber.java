package com.scalar.design.lld.messagequeuev2.models;

import com.scalar.design.lld.messagequeuev2.interfaces.ISubscriber;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class TopicSubscriber {
  private final ISubscriber subscriber;
  private final AtomicInteger offset;


  public TopicSubscriber(ISubscriber subscriber) {
    this.subscriber = subscriber;
    this.offset = new AtomicInteger(0);
  }

  public ISubscriber getSubscriber() {
    return subscriber;
  }

  public AtomicInteger getOffset() {
    return offset;
  }
}
