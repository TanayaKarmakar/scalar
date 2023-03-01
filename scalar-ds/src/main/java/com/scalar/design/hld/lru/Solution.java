package com.scalar.design.hld.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author t0k02w6 on 22/02/23
 * @project scalar
 */
public class Solution {
  private int maxCap;
  private int currentCap;
  private Map<Integer, Item> map;
  private Deque<Item> queue;

  public Solution(int capacity) {
    this.currentCap = 0;
    this.maxCap = capacity;
    map = new HashMap<>();
    queue = new LinkedList<>();
  }

  public int get(int key) {
    if(!map.containsKey(key))
      return -1;
    Item item = map.get(key);
    queue.remove(item);
    queue.addFirst(item);
    return item.value;
  }

  public void set(int key, int value) {
    if(map.containsKey(key)) {
      Item item = map.get(key);
      queue.remove(item);
      item.value = value;
      map.put(key, item);
      queue.addFirst(item);
    } else {
      Item newItem = new Item(key, value);
      if(maxCap == currentCap) {
        Item remItem = queue.pollLast();
        map.remove(remItem.key);
        currentCap--;
      }
      map.put(key, newItem);
      queue.addFirst(newItem);
      currentCap++;
    }
  }

  static class Item {
    int key;
    int value;

    public Item(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
