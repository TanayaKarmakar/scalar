package com.scalar.design.lld.messagequeue.helper;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public interface IConsumer {
  void subscribeToTopic(String topicName);
}
