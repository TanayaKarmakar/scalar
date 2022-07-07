package com.scalar.ds.arrays.advanced.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 27/03/22
 * @project scalar
 */
public class MergeIntervals {
    private static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        if(intervals.size() == 1)
            return intervals;

        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        int prevStart = -1;
        int prevEnd =-1;
        ArrayList<Interval> result = new ArrayList<>();
        for(Interval currentInterval: intervals) {
            if(prevStart == -1) {
                prevStart = currentInterval.start;
                prevEnd = currentInterval.end;
            } else {
                if(currentInterval.start < prevEnd) {
                    prevStart = Integer.min(prevStart, currentInterval.start);
                    prevEnd = Integer.max(prevEnd, currentInterval.end);
                } else {
                    result.add(new Interval(prevStart, prevEnd));
                    prevStart = currentInterval.start;;
                    prevEnd = currentInterval.end;;
                }
            }
        }
        if(result.isEmpty()) {
            result.add(new Interval(prevStart, prevEnd));
        }

        else if(result.get(result.size() - 1).start != prevStart && result.get(result.size() - 1).end != prevEnd) {
            result.add(new Interval(prevStart, prevEnd));
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(8,10));

        List<Interval> result = insert(intervals, new Interval(1,12));

        System.out.println(result);
    }
}
