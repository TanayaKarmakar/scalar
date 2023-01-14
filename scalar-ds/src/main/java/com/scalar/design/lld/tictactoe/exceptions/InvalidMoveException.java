package com.scalar.design.lld.tictactoe.exceptions;

/**
 * @author t0k02w6 on 14/01/23
 * @project scalar-ds
 */
public class InvalidMoveException extends RuntimeException {
  public InvalidMoveException(String message) {
    super(message);
  }
}
