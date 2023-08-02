package com.scalar.design.lld.bloomfilter;

/**
 * @author t0k02w6 on 04/06/23
 * @project scalar-ds
 */
public class BloomFilter {
  private int maxSize;
  private boolean[] filter;

  public BloomFilter(int size) {
    this.maxSize = size;
    this.filter = new boolean[size];
  }

  public void add(String key) {
    int indx = HashUtil.getHash(key, maxSize);
    filter[indx] = true;
    System.out.println("Wrote key " + key + " at index " + indx);
  }

  public boolean exists(String key) {
    int indx = HashUtil.getHash(key, maxSize);
    return filter[indx];
  }
}
