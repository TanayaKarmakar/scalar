package com.scalar.design.lld.messagequeue.service;

import com.scalar.design.lld.messagequeue.helper.IConsumer;
import com.scalar.design.lld.messagequeue.helper.IProducer;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public interface IQueueService {
  void createTopic(String name);

  IProducer createProducer(String name);

  IConsumer createConsumer(String name);
}
