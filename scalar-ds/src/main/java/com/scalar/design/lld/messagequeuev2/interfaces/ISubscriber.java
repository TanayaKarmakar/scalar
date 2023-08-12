package com.scalar.design.lld.messagequeuev2.interfaces;

import com.scalar.design.lld.messagequeuev2.models.Message;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public interface ISubscriber {
  String getId();
  void consume(Message message) throws InterruptedException;
}
