package com.scalar.design.lld.messagequeuev2;

import com.scalar.design.lld.messagequeuev2.interfaces.ISubscriber;
import com.scalar.design.lld.messagequeuev2.models.Message;
import java.util.Objects;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class SleepingSubscriber implements ISubscriber  {
  private final String id;
  private final int sleepingTimeInMillis;

  public SleepingSubscriber(String id, int sleepingTimeInMillis) {
    this.id = id;
    this.sleepingTimeInMillis = sleepingTimeInMillis;
  }


  @Override
  public String getId() {
    return id;
  }

  @Override
  public void consume(Message message) throws InterruptedException {
    System.out.println("Started consuming message : " + message);
    Thread.sleep(sleepingTimeInMillis);
    System.out.println("Completed consuming message : " + message);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SleepingSubscriber that = (SleepingSubscriber) o;
    return sleepingTimeInMillis == that.sleepingTimeInMillis && Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), sleepingTimeInMillis);
  }
}
