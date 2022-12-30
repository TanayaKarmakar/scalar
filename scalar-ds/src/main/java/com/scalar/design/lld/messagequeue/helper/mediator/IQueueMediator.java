package com.scalar.design.lld.messagequeue.helper.mediator;

import com.scalar.design.lld.messagequeue.entities.Message;
import java.util.Optional;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public interface IQueueMediator {
  void addTopic(String topicName);

  void publishToTopic(Message message, String topicName);

  Optional<Message> readMessageIfPresent(String topicName, int offSet);
}
