package com.scalar.ds.arrays.advanced.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author t0k02w6 on 16/03/22
 * @project scalar
 */
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
    }
}

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int prevStart = -1;
        int prevEnd = -1;
        Collections.sort(intervals, new IntervalComparator());
        ArrayList<Interval> finalList = new ArrayList<>();
        for(Interval interval: intervals) {
            if(prevStart == -1 && prevEnd == -1) {
                prevStart = interval.start;
                prevEnd = interval.end;
            } else if(interval.start <= prevEnd) {
                prevStart = Integer.min(prevStart, interval.start);
                prevEnd = Integer.max(prevEnd, interval.end);
            } else {
                finalList.add(new Interval(prevStart, prevEnd));
                prevStart = interval.start;
                prevEnd = interval.end;
            }
        }
        finalList.add(new Interval(prevStart, prevEnd));
        return finalList;
    }

    public static void main(String[] args) {

    }
}
