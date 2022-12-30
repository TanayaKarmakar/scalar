package com.scalar.design.lld.messagequeue.helper;

import com.scalar.design.lld.messagequeue.entities.Message;
import java.util.Optional;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public interface ITopic {
  void enqueueMessage(Message message);

  Optional<Message> readIfPresentMessage(int offset);
}
