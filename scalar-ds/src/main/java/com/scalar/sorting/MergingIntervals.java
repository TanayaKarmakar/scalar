package com.scalar.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 22/04/22
 * @project scalar
 */
public class MergingIntervals {
    private static List<int[]> mergeIntervals(List<int[]> intervals, int start, int end) {

        int low = 0;
        int high = intervals.size();

        int insertIndx = -1;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(mid - 1 >= 0 && intervals.get(mid - 1)[0] <= start && intervals.get(mid)[0] >= start) {
                insertIndx = mid;
                break;
            } else if(mid + 1 < intervals.size() && intervals.get(mid)[0] <= start && intervals.get(mid + 1)[0] >= start) {
                insertIndx = mid + 1;
                break;
            } else if(intervals.get(mid)[0] > start)
                high = mid - 1;
            else
                low = mid + 1;
        }
        intervals.add(insertIndx, new int[]{start, end});

        List<int[]> result = new ArrayList<>();
        int prevStart = -1;
        int prevEnd = -1;

        for(int i = 0; i < intervals.size(); i++) {
            if(prevStart == -1) {
                prevStart = intervals.get(i)[0];
                prevEnd = intervals.get(i)[1];
            } else {
                if(prevEnd > intervals.get(i)[0]) {
                    prevStart = Integer.min(prevStart, intervals.get(i)[0]);
                    prevEnd = Integer.max(prevEnd, intervals.get(i)[1]);
                } else {
                    result.add(new int[]{prevStart, prevEnd});
                    prevStart = intervals.get(i)[0];
                    prevEnd = intervals.get(i)[1];
                }
            }
        }
        result.add(new int[]{prevStart, prevEnd});

        return result;
    }


    public static void main(String[] args) {
        int startInterval = 8;
        int endInterval = 12;

        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[] {1,3});
        intervals.add(new int[] {5, 9});
        intervals.add(new int[] {10, 11});
        intervals.add(new int[] {13,16});
        intervals.add(new int[] {17,20});

        List<int[]> res = mergeIntervals(intervals, startInterval, endInterval);

        for(int[] curr: res) {
            System.out.println(Arrays.toString(curr));
        }
    }
}
