package com.scalar.design.lld.messagequeue;

import com.scalar.design.lld.messagequeue.helper.IConsumer;
import com.scalar.design.lld.messagequeue.helper.IProducer;
import com.scalar.design.lld.messagequeue.service.IQueueService;
import com.scalar.design.lld.messagequeue.service.QueueServiceImpl;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public class QueueDemo {
  IQueueService queueService = QueueServiceImpl.getInstance();

  public static void main(String[] args) {
    QueueDemo queueMain = new QueueDemo();
    queueMain.runDemo();
  }

  private void runDemo() {
    queueService.createTopic("topic1");
    queueService.createTopic("topic2");

    IProducer producer1 = queueService.createProducer("producer1");
    IProducer producer2 = queueService.createProducer("producer2");

    IConsumer consumer1 = queueService.createConsumer("consumer1");
    IConsumer consumer2 = queueService.createConsumer("consumer2");
    IConsumer consumer3 = queueService.createConsumer("consumer3");
    IConsumer consumer4 = queueService.createConsumer("consumer4");
    IConsumer consumer5 = queueService.createConsumer("consumer5");


  }
}
