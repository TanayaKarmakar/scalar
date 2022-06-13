package com.scalar.linkedlist.advanced.assignment;

import java.util.*;

/**
 * @author t0k02w6 on 04/06/22
 * @project scalar
 */
class Solution {
    Map<Integer, Item> map;
    int capacity;
    int currentCapacity;
    Deque<Item> queue;


    public Solution(int capacity) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        this.capacity = capacity;
        this.currentCapacity = 0;
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
        if(!map.containsKey(key)) {
            if(currentCapacity == capacity) {
                Item item = queue.removeLast();
                map.remove(item.key);
                currentCapacity--;
            }
            Item newItem = new Item(key, value);
            map.put(key, newItem);
            queue.addFirst(newItem);
            currentCapacity++;
        } else {
            Item item = map.get(key);
            queue.remove(item);

            item.value = value;
            map.put(key, item);
            queue.addFirst(item);
            //currentCapacity++;
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


public class LRUCache {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOps = scanner.nextInt();
        int capacity = scanner.nextInt();
        Solution solution = new Solution(capacity);

        for(int i = 0; i < numOps; i++) {
            String type = scanner.next();
            if(type.equals("S")) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                solution.set(key, value);
            } else {
                int key = scanner.nextInt();
                System.out.println(solution.get(key));
            }
        }
        scanner.close();
    }
}
