package com.scalar.design.lld.messagequeue.helper;

import com.scalar.design.lld.messagequeue.entities.Message;
import com.scalar.design.lld.messagequeue.helper.mediator.IQueueMediator;
import com.scalar.design.lld.messagequeue.helper.mediator.QueueMediatorImpl;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public class ProducerImpl implements IProducer{
  final String name;
  final IQueueMediator queueMediator;

  public ProducerImpl(String name) {
    this.name = name;
    this.queueMediator = QueueMediatorImpl.getInstance();
  }

  @Override
  public void publishToTopic(String message, String topicName) {
    System.out.printf("%s sent message: %s on topic: %s%n", name, message, topicName);
    queueMediator.publishToTopic(new Message(message), topicName);
  }
}
