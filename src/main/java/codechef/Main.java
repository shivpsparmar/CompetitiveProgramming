package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 17-02-2016 Description:
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException,IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int array[] = GetArray(br.readLine(), 2);
        int n = array[0];
        int k = array[1];
        int a[] = GetArray(br.readLine(), n);
        Deque<Point> dq = new ArrayDeque<Point>();

        long p = a[0];
        dq.add(new Point(Math.log10(a[0]), p, 0));

        for (int i = 1; i < n; i++) {
            Point min;
            double log;
            int start = Math.max(0, i - k);

            while (!dq.isEmpty() && dq.peekFirst().index < start) {
                dq.pollFirst();
            }

            min = dq.peekFirst();
            p = (min.product * (long) a[i]) % 1000000007;
            log  = min.log + Math.log10(a[i]);

            while (!dq.isEmpty() && dq.peekLast().log > log) {
                dq.pollLast();
            }
            dq.addLast(new Point(log, p, i));
        }
        System.out.println(p);
    }

    private static class Point implements Comparable<Point> {
        double log;
        int index;
        long product;

        public Point(double log10, long p, int index) {
            log = log10;
            this.index = index;
            product = p;
        }

        @Override
        public int compareTo(Point o) {
            if (log - o.log < 0) {
                return -1;
            } else {
                return 1;
            }
        }

    }

    public static int[] GetArray(String line, int n) {
        int[] ret = new int[n];
        int start = 0;
        int end = line.indexOf(' ', start);

        for (int i = 0; i < n; i++) {
            if (end > 0)
                ret[i] = Integer.parseInt(line.substring(start, end));
            else
                ret[i] = Integer.parseInt(line.substring(start));
            start = end + 1;
            end = line.indexOf(' ', start);
        }
        return ret;
    }
}