package com.scalar.design.lld.cache.policies;

import com.scalar.design.lld.cache.algorithms.DoublyLinkedList;
import com.scalar.design.lld.cache.algorithms.DoublyLinkedListNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 10/08/23
 * @project scalar-ds
 */
public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {
  DoublyLinkedList<Key> list;
  Map<Key, DoublyLinkedListNode<Key>> map;

  public LRUEvictionPolicy() {
    list = new DoublyLinkedList<>();
    map = new HashMap<>();
  }


  @Override
  public void keyAccessed(Key key) {
    if(map.containsKey(key)) {
      list.detachNode(map.get(key));
      list.addNodeAtLast(map.get(key));
    } else {
      DoublyLinkedListNode<Key> newNode = list.addElementAtLast(key);
      map.put(key, newNode);
    }
  }

  @Override
  public Key evictKey() {
    DoublyLinkedListNode<Key> keyToBeEvicted = list.getFirstNode();
    if(keyToBeEvicted == null)
      return null;
    list.detachNode(keyToBeEvicted);
    Key key = keyToBeEvicted.getElement();
    map.remove(key);
    return key;
  }
}
