package interviewbit.Arrays;

import java.util.List;

/**
 * Created by shivparmar01 on 12-02-2016.
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example:
 * 
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 * 
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * For this problem, return the maximum sum.
 */
public class MaxSum {
    // DO NOT MODFIY THE LIST.
    public int maxSubArray(final List<Integer> a) {
        int maximum_till_now = 0;
        int maximum_so_far = a.get(0);
        int x;
        for (int i = 0; i < a.size(); i++) {
            x = a.get(i);
            maximum_till_now += x;
            maximum_till_now = x > maximum_till_now ? x : maximum_till_now;
            maximum_so_far = maximum_so_far > maximum_till_now ? maximum_so_far : maximum_till_now;
        }
        return maximum_so_far;
    }
}
