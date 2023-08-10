package com.scalar.design.lld.cache.storage;

import com.scalar.design.lld.cache.exceptions.NotFoundException;
import com.scalar.design.lld.cache.exceptions.StorageFullException;

/**
 * @author t0k02w6 on 09/08/23
 * @project scalar-ds
 */
public interface Storage<Key, Value> {
  void add(Key key, Value value) throws StorageFullException;

  void remove(Key key) throws NotFoundException;

  Value get(Key key) throws NotFoundException;
}
