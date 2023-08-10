package com.scalar.design.lld.cache.storage;

import com.scalar.design.lld.cache.exceptions.NotFoundException;
import com.scalar.design.lld.cache.exceptions.StorageFullException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 09/08/23
 * @project scalar-ds
 */
public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
  private Map<Key, Value> storage;
  private Integer capacity;

  public HashMapBasedStorage(Integer capacity) {
    this.storage = new HashMap<>();
    this.capacity = capacity;
  }

  @Override
  public void add(Key key, Value value) throws StorageFullException {
    if(isStorageFull())
      throw new StorageFullException("Storage is full");
    storage.put(key, value);
  }

  @Override
  public void remove(Key key) throws NotFoundException {
    if(!storage.containsKey(key))
      throw new NotFoundException(key + " doesn't exist in cache");
    storage.remove(key);
  }

  @Override
  public Value get(Key key) throws NotFoundException {
    if(!storage.containsKey(key))
      throw new NotFoundException(key + " doesn't exist in cache");
    return storage.get(key);
  }

  private boolean isStorageFull() {
    return storage.size() == capacity;
  }
}
