package com.scalar.ds.revision.arrays.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author t0k02w6 on 26/07/22
 * @project scalar
 */
public class MergeIntervals {
    static class Interval {
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

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new IntervalComparator());

        ArrayList<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++) {
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;
            if(currentStart < end) {
                start = Integer.min(start, currentStart);
                end = Integer.max(end, currentEnd);
            } else {
                result.add(new Interval(start, end));
                start = currentStart;
                end = currentEnd;
            }
        }

        if(result.isEmpty()) {
            result.add(new Interval(start, end));
        }

        int size = result.size();
        if(result.get(size - 1).start != start && result.get(size - 1).end != end) {
            result.add(new Interval(start, end));
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
