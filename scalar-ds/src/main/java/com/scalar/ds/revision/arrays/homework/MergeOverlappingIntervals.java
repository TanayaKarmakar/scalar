package com.scalar.ds.revision.arrays.homework;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author t0k02w6 on 21/07/22
 * @project scalar
 */
public class MergeOverlappingIntervals {
    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    private static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        ArrayList<Interval> result = new ArrayList<>();
        for(int i = 1; i < intervals.size(); i++) {
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;
            if(currentStart <= end) {
                start = Integer.min(start, currentStart);
                end = Integer.max(end, currentEnd);
            } else {
                result.add(new Interval(start, end));
                start = currentStart;
                end = currentEnd;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(2,6));
        input.add(new Interval(8,10));
        input.add(new Interval(15,18));

        ArrayList<Interval> result = merge(input);
        System.out.println(result);
    }
}
