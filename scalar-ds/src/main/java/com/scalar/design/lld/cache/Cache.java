package com.scalar.design.lld.cache;

import com.scalar.design.lld.cache.exceptions.NotFoundException;
import com.scalar.design.lld.cache.exceptions.StorageFullException;
import com.scalar.design.lld.cache.policies.EvictionPolicy;
import com.scalar.design.lld.cache.storage.Storage;

/**
 * @author t0k02w6 on 10/08/23
 * @project scalar-ds
 */
public class Cache<Key, Value> {
  private final Storage<Key, Value> storage;
  private final EvictionPolicy<Key> evictionPolicy;

  public Cache(final Storage<Key, Value> storage, final EvictionPolicy<Key> evictionPolicy) {
    this.storage = storage;
    this.evictionPolicy = evictionPolicy;
  }

  public void put(Key key, Value value) {
    try {
      this.storage.add(key, value);
      this.evictionPolicy.keyAccessed(key);
    } catch (StorageFullException ex) {
      System.out.println("Storage is full evicting some item");
      Key evictedKey = this.evictionPolicy.evictKey();
      if(evictedKey == null) {
        throw new RuntimeException("Unexpected state. Storage is full and no key to evict");
      }
      this.storage.remove(evictedKey);
      System.out.println("Creating space by evicting item " + evictedKey);
      put(key, value);
    }
  }

  public Value get(Key key) {
    try {
      Value value = this.storage.get(key);
      evictionPolicy.keyAccessed(key);
      return value;
    } catch (NotFoundException notFoundException) {
      System.out.println(key + " not found in the cache");
      return null;
    }
  }
}
