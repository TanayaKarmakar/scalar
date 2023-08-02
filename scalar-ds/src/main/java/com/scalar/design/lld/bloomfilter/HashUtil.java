package com.scalar.design.lld.bloomfilter;

import org.apache.commons.codec.digest.MurmurHash3;

/**
 * @author t0k02w6 on 04/06/23
 * @project scalar-ds
 */
public class HashUtil {
  public static int getHash(String key, int size) {
    long value = Math.abs(MurmurHash3.hash32(key));
    return (int)(value % size);
  }


}
