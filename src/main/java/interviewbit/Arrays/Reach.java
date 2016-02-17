package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 12-02-2016.
 * 
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * 
 * (x,y) to (x+1, y), (x - 1, y), (x, y+1), (x, y-1), (x-1, y-1), (x+1,y+1), (x-1,y+1), (x+1,y-1) You are given a
 * sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you
 * can achieve it. You start from the first point.
 * 
 * Example :
 * 
 * Input : [(0, 0), (1, 1), (1, 2)] Output : 2 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to
 * move from (1, 1) to (1, 2).
 * 
 * This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See
 * Expected Output” section.
 */
public class Reach {

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        int step = 0;
        for (int i = 0; i < x.size() - 1; i++) {
            step += steps(x.get(i), y.get(i), x.get(i + 1), y.get(i + 1));
        }
        return step;
    }

    private int steps(int a, int b, int c, int d) {
        int step = 0;
        int x = c - a;
        int y = d - b;
        x = (x < 0) ? (x * (-1)) : x;
        y = (y < 0) ? (y * (-1)) : y;
        step = x >= y ? x : y;
        return step;
    }
}
