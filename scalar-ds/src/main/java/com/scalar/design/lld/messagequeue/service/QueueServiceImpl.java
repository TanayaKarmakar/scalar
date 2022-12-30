package com.scalar.design.lld.messagequeue.service;

import com.scalar.design.lld.messagequeue.helper.ConsumerImpl;
import com.scalar.design.lld.messagequeue.helper.IConsumer;
import com.scalar.design.lld.messagequeue.helper.IProducer;
import com.scalar.design.lld.messagequeue.helper.ProducerImpl;
import com.scalar.design.lld.messagequeue.helper.mediator.IQueueMediator;
import com.scalar.design.lld.messagequeue.helper.mediator.QueueMediatorImpl;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public class QueueServiceImpl implements IQueueService{
  private static final IQueueService INSTANCE = new QueueServiceImpl();
  private final IQueueMediator queueMediator;

  private QueueServiceImpl() {
    this.queueMediator = QueueMediatorImpl.getInstance();
  }

  public static IQueueService getInstance() {
    return INSTANCE;
  }

  @Override
  public void createTopic(String name) {
    queueMediator.addTopic(name);
  }

  @Override
  public IProducer createProducer(String name) {
    return new ProducerImpl(name);
  }

  @Override
  public IConsumer createConsumer(String name) {
    return new ConsumerImpl(name);
  }
}
