package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 11-02-2016.
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Make sure the returned intervals are also sorted.
 */
public class IntervalSolv {
    public static void main(final String[] args) {
        ArrayList<Interval> alis = getIntervals("(6037774, 6198243), (6726550, 7004541),"
            + " (8842554, 10866536), (11027721, 11341296), (11972532, 14746848), (16374805, 16706396), (17557262, 20518214), (22139780, 22379559), (27212352, 28404611), (28921768, 29621583), (29823256, 32060921), (33950165, 36418956), (37225039, 37785557), (40087908, 41184444), (41922814, 45297414), (48142402, 48244133), (48622983, 50443163), (50898369, 55612831), (57030757, 58120901), (59772759, 59943999), (61141939, 64859907), (65277782, 65296274), (67497842, 68386607), (70414085, 73339545), (73896106, 75605861), (79672668, 84539434), (84821550, 86558001), (91116470, 92198054), (96147808, 98979097)");
        Interval interval = new Interval(36210193, 61984219);
        // alis = getIntervals("(1, 2), (3, 6)");
        // interval = new Interval(8, 10);
        alis = new IntervalSolv().insert1(alis, interval);
        print(alis);
    }

    private static ArrayList<Interval> getIntervals(String s) {
        ArrayList<Interval> alist = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        s = s.replace('(', ' ');
        s = s.replace(')', ' ');
        s = s.replaceAll("\\s+", "");
        String[] sp = s.split(",");
        for (int i = 1; i < sp.length; i = i + 2) {
            int start = Integer.parseInt(sp[i - 1]);
            int end = Integer.parseInt(sp[i]);
            alist.add(new Interval(start, end));
        }
        return alist;
    }

    private static void print(ArrayList<Interval> a) {
        StringBuilder str = new StringBuilder();
        for (Interval as : a) {
            str.append("(").append(as.start).append(", ").append(as.end).append(") ");
        }
        // str.deleteCharAt(str.length()-1);
        System.out.println(str);
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        check(newInterval);
        int i;
        outer: for (i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInterval.start > interval.start && newInterval.start >= interval.end) {
            } else if (interval.start <= newInterval.start) {
                if (interval.end < newInterval.start) {
                    for (int j = i + 1; j < intervals.size(); j++) {
                        if (intervals.get(j).end >= newInterval.end) {
                            intervals.set(i, new Interval(interval.start, intervals.get(j).end));
                            for (int k = i + 1, l = i + 1; k <= j; k++) {
                                intervals.remove(l);
                            }
                            break outer;
                        }
                    }
                }
            } else if (interval.start > newInterval.start) {
                if (interval.start > newInterval.end) {
                    intervals.add(i, newInterval);
                    break outer;
                }
                if (interval.end >= newInterval.end) {
                    intervals.set(i, new Interval(newInterval.start, interval.end));
                    break outer;
                } else {
                    intervals.set(i, newInterval);
                    break outer;
                }
            }
        }
        if (i == intervals.size()) {
            intervals.add(newInterval);
        }
        return intervals;
    }

    public ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {
        check(newInterval);
        int i;
        for (i = 0; i < intervals.size(); i++) {
            if (newInterval.start < intervals.get(i).start) {
                intervals.add(i, newInterval);
                break;
            }
        }
        if (i == intervals.size()) {
            intervals.add(newInterval);
        }
        intervals=removeOverlap(intervals);
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
            if (pre.end > current.start) {
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
        ArrayList<Interval> result= new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i]!=null){
                result.add(intervals[i]);
            }
        }
        return result;
    }

    private void check(Interval newInterval) {
        if (newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
    }

}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
