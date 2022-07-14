package com.scalar.ds.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 13/07/22
 * @project scalar
 */
public class FreeCars {
    static class CarItem {
        int time;
        int beauty;

        public CarItem(int time, int beauty) {
            this.time = time;
            this.beauty = beauty;
        }
    }

    static class TimeComparator implements Comparator<CarItem> {

        @Override
        public int compare(CarItem o1, CarItem o2) {
            return o1.time - o2.time;
        }
    }

    static class BeautyComparator implements Comparator<CarItem> {

        @Override
        public int compare(CarItem o1, CarItem o2) {
            return o1.beauty - o2.beauty;
        }
    }

    private static int maxBeauty(int[] time, int[] beauty) {
        int n = time.length;
        CarItem[] carItems = new CarItem[n];
        for(int i = 0; i < n; i++) {
            carItems[i] = new CarItem(time[i], beauty[i]);
        }

        Arrays.sort(carItems, new TimeComparator());
        int currentTime = 0;
        PriorityQueue<CarItem> pQ = new PriorityQueue<>(new BeautyComparator());
        for(int i = 0; i < n; i++) {
            if(carItems[i].time < currentTime) {
                pQ.add(carItems[i]);
                currentTime++;
            } else {
                if(carItems[i].time == currentTime) {
                    if(!pQ.isEmpty() && pQ.peek().beauty < carItems[i].beauty) {
                        pQ.poll();
                        pQ.add(carItems[i]);
                    }
                }
            }
        }

        int totalBeauty = 0;
        while(!pQ.isEmpty()) {
            totalBeauty += pQ.poll().beauty;
        }
        return totalBeauty;
    }

    public static void main(String[] args) {

    }
}
