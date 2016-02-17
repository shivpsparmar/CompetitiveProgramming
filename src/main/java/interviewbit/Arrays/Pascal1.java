package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 12-02-2016. Given numRows, generate the first numRows of Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 * 
 * Example:
 * 
 * Given numRows = 5,
 * 
 * Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 */
public class Pascal1 {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < a; i++) {
            int pr = 1;
            ans.add(new ArrayList<Integer>());
            for (int j = 0; j <= i; j++) {
                ans.get(i).add(pr);
                pr = pr * (i - j) / (j + 1);
            }
        }
        return ans;
    }
}
