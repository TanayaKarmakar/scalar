package com.scalar.design.lld.messagequeuev2.models;

/**
 * @author t0k02w6 on 12/08/23
 * @project scalar-ds
 */
public class Message {
  private final String message;

  public Message(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "Message{" +
        "message='" + message + '\'' +
        '}';
  }
}
