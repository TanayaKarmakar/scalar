package com.scalar.design.lld.messagequeuev2;


import com.scalar.design.lld.messagequeuev2.interfaces.ISubscriber;
import com.scalar.design.lld.messagequeuev2.models.Message;
import com.scalar.design.lld.messagequeuev2.models.Topic;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Main {
  public static void main(String[] args) {
    Queue queue = new Queue();
    Topic topic = queue.createTopic("Topic-1");

    ISubscriber sub1 = new SleepingSubscriber("sub-1", 1000);
    ISubscriber sub2 = new SleepingSubscriber("sub-2", 500);
    queue.addSubscriber(sub1, topic);
    queue.addSubscriber(sub2, topic);

    Message message = new Message("My Test Message");
    queue.publish(topic, message);
  }
}
