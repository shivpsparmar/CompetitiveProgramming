package interviewbit.math;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 15-02-2016 Description: Given a number N, find all factors of N.
 * 
 * Example:
 * 
 * N = 6 factors = {1, 2, 3, 6} Make sure the returned array is sorted.
 */
public class Factor {
    public static void main(String[] args) {
        System.out.println(new Factor().allFactors(15));
    }

    public ArrayList<Integer> allFactors(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (a == 0) {
            ans.add(0);
            return ans;
        }
        ans.add(1);
        int sqrt = (int) Math.sqrt(a);

        for (int i = 2; i <= sqrt; i++) {
            if (a % i == 0) {
                ans.add(i);
                if ((a / i) != sqrt) {
                    ans.add(a / i);
                }
            }
        }
        ans.add(a);
        Collections.sort(ans);
        return ans;
    }
}
