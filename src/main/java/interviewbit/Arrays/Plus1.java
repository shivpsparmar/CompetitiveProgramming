package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 12-02-2016.
 * 
 * Given a non-negative number represented as an array of digits,
 * 
 * add 1 to the number ( increment the number represented by the digits ).
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * Example:
 * 
 * If the vector has [1, 2, 3]
 * 
 * the returned vector should be [1, 2, 4]
 * 
 * as 123 + 1 = 124.
 * 
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the
 * interviewer. For example, for this problem, following are some good questions to ask : Q : Can the input have 0’s
 * before the most significant digit. Or in other words, is 0 1 2 3 a valid input? A : For the purpose of this question,
 * YES Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output? A :
 * For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class Plus1 {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        ArrayList<Integer> ans = new ArrayList<>(a);
        for (int i = a.size() - 1; i >= 0; i--) {
            if ((ans.get(i) + 1) > 9) {
                ans.set(i, 0);
                if (i == 0) {
                    ArrayList<Integer> plusOneArray = new ArrayList<>();
                    plusOneArray.add(1);
                    plusOneArray.addAll(ans);
                    ans = plusOneArray;
                }
            } else {
                ans.set(i, ans.get(i) + 1);
                break;
            }
        }

        int startIndex = 0;
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) == 0) {
                startIndex++;
            } else {
                break;
            }
        }
        return new ArrayList<>(ans.subList(startIndex, ans.size()));

    }

}
