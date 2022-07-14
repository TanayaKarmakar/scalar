package com.scalar.ds.greedy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 13/07/22
 * @project scalar
 */
public class FractionalKnapsack {
    static class Item implements Comparable<Item>{
        int item;
        int price;
        int value;

        public Item(int item, int price, int value) {
            this.item = item;
            this.price = price;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return o.value - this.value;
        }
    }

    private static int maxCost(int[] items, int[] prices, int W) {
        int n = items.length;
        Item[] selectionItems = new Item[n];

        for(int i = 0; i < n; i++) {
            Item selectionItem = new Item(items[i], prices[i], prices[i]/items[i]);
            selectionItems[i] = selectionItem;
        }

        Arrays.sort(selectionItems);

        int totalCost = 0;
        for(Item selectionItem: selectionItems) {
            if(selectionItem.item < W) {
                totalCost += selectionItem.price;
                W = W - selectionItem.item;
            } else {
                int cost = selectionItem.value * W;
                totalCost += cost;
                W = 0;
                break;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] items = {10,20,30};
        int[] prices = {60,100,120};
        int W = 50;

        int ans = maxCost(items, prices, W);

        System.out.println(ans);
    }
}
