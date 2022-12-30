package com.scalar.design.lld.messagequeue.entities;

/**
 * @author t0k02w6 on 30/12/22
 * @project scalar-ds
 */
public class Message {
  final String message;


  public Message(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
