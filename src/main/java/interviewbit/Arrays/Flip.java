package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 12-02-2016. You are given a binary string(i.e. with characters 0 and 1) S consisting of
 * characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip
 * the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
 * 
 * You aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to
 * perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If
 * there are multiple solutions, return the lexicographically smallest pair of L and R.
 * 
 * Notes: - Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == b, then b < d.
 * 
 * For example,
 * 
 * S = 010
 * 
 * Pair of [L, R] | Final string _______________|_____________ [1 1] | 110 [1 2] | 100 [1 3] | 101 [2 2] | 000 [2 3] |
 * 001
 * 
 * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1]. Another
 * example,
 * 
 * If S = 111
 * 
 * No operation can give us more than three 1s in final string. So, we return empty array [].
 */
public class Flip {
    public ArrayList<Integer> flip(String A) {
        char arr[] = A.toCharArray();
        int right = -1, left = -1;
        long sum = 0;
        long maxSum = 0;
        int ansRight = -1;
        int ansLeft = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                left = i;
                right = i;
                break;
            }
        }

        for (int i = right; i >= 0; i--) {
            if (arr[i] == '0') {
                sum++;
                left = i;
            } else {
                sum--;
                left = i;
            }

            if (maxSum <= sum && sum != 0) {
                maxSum = sum;
                ansLeft = left;
                ansRight = right;
            }
            if (sum <= 0) {
                left = i;
                right = i - 1;
                sum = 0;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if (!(ansLeft == -1 && ansRight == -1)) {
            ans.add(ansLeft + 1);
            ans.add(ansRight + 1);
        }
        return ans;
    }
}
