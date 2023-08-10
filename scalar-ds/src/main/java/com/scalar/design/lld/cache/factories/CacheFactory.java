package com.scalar.design.lld.cache.factories;

import com.scalar.design.lld.cache.Cache;
import com.scalar.design.lld.cache.policies.LRUEvictionPolicy;
import com.scalar.design.lld.cache.storage.HashMapBasedStorage;

/**
 * @author t0k02w6 on 10/08/23
 * @project scalar-ds
 */
public class CacheFactory<Key, Value> {
  public Cache<Key, Value> defaultCache(final int capacity) {
    return new Cache<>(new HashMapBasedStorage<>(capacity), new LRUEvictionPolicy<>());
  }
}
