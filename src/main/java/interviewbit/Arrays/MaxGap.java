package interviewbit.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created By : Shiv Pratap Singh Parmar Created On : 12-02-2016 Description:Given an unsorted array, find the maximum
 * difference between the successive elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Example :
 * 
 * Input : [1, 10, 5] Output : 5 Return 0 if the array contains less than 2 elements.
 * 
 * You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer
 * range. You may also assume that the difference will not overflow.
 */

public class MaxGap {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 10, 5);
        System.out.println(new MaxGap().maximumGap(l));
    }

    /**
     *
     * @param a list of number
     * @return return max gap
     */
    public int maximumGap(final List<Integer> a) {
        if (a.size() < 2) {
            return 0;
        }
        Collections.sort(a);
        int differ = 0;
        for (int i = 1; i < a.size(); i++) {
            differ = Math.max(differ, a.get(i) - a.get(i - 1));
        }
        return differ;
    }
}
