package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shivparmar01 on 11-02-2016. Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example:
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 * 
 * Make sure the returned intervals are sorted.
 */
public class Interval2 {
    public static void main(String[] args) {

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new IntervalComp());
        intervals = removeOverlap(intervals);
        return intervals;
    }

    private ArrayList<Interval> removeOverlap(ArrayList<Interval> intervalList) {
        if (intervalList.size() <= 1) {
            return intervalList;
        }
        Interval[] intervals = new Interval[intervalList.size()];
        intervalList.toArray(intervals);
        Interval pre = intervals[0];
        Interval current;
        int preIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            current = intervals[i];
            if (pre.end >= current.start) {
                int newEnd = pre.end > current.end ? pre.end : current.end;
                Interval newInterval = new Interval(pre.start, newEnd);
                intervals[preIndex] = null;
                intervals[i] = newInterval;
                pre = newInterval;
                preIndex = i;
            } else {
                pre = current;
                preIndex = i;
            }
        }
        ArrayList<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                result.add(intervals[i]);
            }
        }
        return result;
    }

    class IntervalComp implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }
}
