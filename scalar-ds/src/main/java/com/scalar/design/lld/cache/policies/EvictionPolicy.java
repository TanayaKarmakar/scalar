package com.scalar.design.lld.cache.policies;

/**
 * @author t0k02w6 on 09/08/23
 * @project scalar-ds
 */
public interface EvictionPolicy<Key> {
  void keyAccessed(Key key);

  Key evictKey();
}
