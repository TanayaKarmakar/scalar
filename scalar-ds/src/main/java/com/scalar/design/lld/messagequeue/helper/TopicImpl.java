package com.scalar.design.lld.messagequeue.helper;

import com.scalar.design.lld.messagequeue.entities.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public class TopicImpl implements ITopic{
  private final List<Message> queue;
  private final Lock messageWriterReentrantLock;

  public TopicImpl() {
    queue = new ArrayList<>(10);
    messageWriterReentrantLock = new ReentrantLock();
  }

  @Override
  public void enqueueMessage(Message message) {
    messageWriterReentrantLock.lock();
    queue.add(message);
    messageWriterReentrantLock.unlock();
  }

  @Override
  public Optional<Message> readIfPresentMessage(int offset) {
    messageWriterReentrantLock.lock();
    if(offset >= queue.size())
      return Optional.empty();
    Message message = queue.get(offset);
    messageWriterReentrantLock.unlock();
    return Optional.of(message);
  }
}
