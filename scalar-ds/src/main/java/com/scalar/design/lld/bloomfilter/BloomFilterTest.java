package com.scalar.design.lld.bloomfilter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author t0k02w6 on 04/06/23
 * @project scalar-ds
 */
public class BloomFilterTest {
  public static void main(String[] args) {
    BloomFilter bloom = new BloomFilter(1000);

//    bf.add("a");
//    bf.add("b");
//    bf.add("c");
//    bf.add("d");
//
//    String[] keys = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m"};
//
//    for(String key: keys) {
//      System.out.println(bf.exists(key));
//    }


    Map<String, Boolean> datasetExists = new HashMap<>();
    Map<String, Boolean> datasetNotExists = new HashMap<>();
    String[] datasets = new String[1000];
    for(int i = 0; i < 500; i++) {
      String uuid = UUID.randomUUID().toString();
      datasets[i]= uuid;
      datasetExists.put(uuid, true);
    }

    for(int i = 0; i < 500; i++) {
      String uuid = UUID.randomUUID().toString();
      datasets[i]= uuid;
      datasetNotExists.put(uuid, true);
    }


    for(Map.Entry<String, Boolean> entry: datasetExists.entrySet()) {
      bloom.add(entry.getKey());
    }

    int truePositive = 0;
    int falsePositive = 0;
    for(int i = 0; i < datasets.length; i++) {
      if(bloom.exists(datasets[i])) {
        if(datasetExists.containsKey(datasets[i]))
          truePositive++;
        if(datasetNotExists.containsKey(datasets[i]))
          falsePositive++;
      }
    }

    System.out.println("False Positive " + falsePositive/datasets.length);

  }
}
