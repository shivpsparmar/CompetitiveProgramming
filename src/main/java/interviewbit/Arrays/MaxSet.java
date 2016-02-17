package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by Shiv Pratap Singh Parmar on 12-02-2016.
 * 
 * Find out the maximum sub-array of non negative numbers from an array. The sub-array should be continuous. That is, a
 * sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * 
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than
 * sub-array B if sum(A) > sum(B).
 * 
 * Example:
 * 
 * A : [1, 2, 5, -7, 2, 3] The two sub-arrays are [1, 2, 5] [2, 3]. The answer is [1, 2, 5] as its sum is larger than
 * [2, 3] NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length NOTE
 * 2: If there is still a tie, then return the segment with minimum starting index
 */
public class MaxSet {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long maxSum = 0;
        long sum = 0;
        int left = 0;
        int right = -1;
        int ansLeft = -1;
        int ansRight = -1;

        for (int i = 0; i < a.size(); i++) {

            if (a.get(i) < 0) {
                sum = 0;
                left = i + 1;
                right = i + 1;
                continue;
            }
            sum += a.get(i);
            right = i;
            if (sum >= maxSum) {
                if (sum == maxSum) {
                    if (right - left >= ansRight - ansLeft) {

                        if (right - left == ansRight - ansLeft) {
                            if (left < ansLeft) {
                                ansLeft = left;
                                ansRight = right;
                            }
                        } else {
                            ansLeft = left;
                            ansRight = right;
                        }
                    }

                } else {
                    ansLeft = left;
                    ansRight = right;
                    maxSum = sum;
                }
            }
        }
        if (ansLeft == -1 || ansRight == -1) {
            return new ArrayList<>();
        }
        return new ArrayList<>(a.subList(ansLeft, ansRight + 1));
    }
}
