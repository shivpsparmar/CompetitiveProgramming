package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 12-02-2016.
 * 
 * Given an index k, return the kth row of the Pascal’s triangle. Pascal’s triangle : To generate A[C] in row R, sum up
 * A’[C] and A’[C-1] from previous row R - 1.
 * 
 * Example:
 * 
 * Input : k = 3
 * 
 * Return : [1,3,3,1] NOTE : k is 0 based. k = 0, corresponds to the row [1]. Note:Could you optimize your algorithm to
 * use only O(k) extra space?
 */
public class Pascal2 {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int number = 1;
        for (int j = 0; j <= a; j++) {
            ans.add(number);
            number = number * (a - j) / (j + 1);
        }
        return ans;
    }
}
