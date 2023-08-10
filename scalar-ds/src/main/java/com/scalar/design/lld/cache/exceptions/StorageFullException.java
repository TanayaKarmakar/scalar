package com.scalar.design.lld.cache.exceptions;

/**
 * @author t0k02w6 on 09/08/23
 * @project scalar-ds
 */
public class StorageFullException extends RuntimeException {
  public StorageFullException(String message) {
    super(message);
  }
}
