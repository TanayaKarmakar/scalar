package com.scalar.design.lld.messagequeue.helper.mediator;

import com.scalar.design.lld.messagequeue.entities.Message;
import com.scalar.design.lld.messagequeue.helper.ITopic;
import com.scalar.design.lld.messagequeue.helper.TopicImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public class QueueMediatorImpl implements IQueueMediator{
  private static final IQueueMediator INSTANCE = new QueueMediatorImpl();
  private Map<String, ITopic> topicMap;

  private QueueMediatorImpl() {
    topicMap = new HashMap<>();
  }

  public static IQueueMediator getInstance() {
    return INSTANCE;
  }

  @Override
  public void addTopic(String topicName) {
    if(!topicMap.containsKey(topicName))
      topicMap.put(topicName, new TopicImpl());
  }

  @Override
  public void publishToTopic(Message message, String topicName) {
    topicMap.get(topicName).enqueueMessage(message);
  }

  @Override
  public Optional<Message> readMessageIfPresent(String topicName, int offSet) {
    return topicMap.get(topicName).readIfPresentMessage(offSet);
  }
}
