package interviewbit.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 16-02-2016 Description: Given a positive integer which fits in a 32 bit signed integer, find if it can
 * be expressed as A^P where P > 1 and A > 0. A and P both should be integers.
 * 
 * Example
 * 
 * Input : 4 Output : True as 2^2 = 4.
 */
public class Power2 {
    private Sieve sieve;

    public Power2(final Sieve sieve) {
        this.sieve = sieve;
    }

    public static void main(String[] args) {

        System.out.println(new Power2(new Sieve()).isPower(1024000000));
    }

    /**
     * Works fine in 10^5 operation
     * 
     * @param num
     * @return
     */
    public boolean isPower(int num) {
        if (num == 1) {
            return true;
        }

        for (int b = 2; b <= 32; b++) {
            for (int a = 2; a <= num; a++) {
                int power = (int) Math.pow(a, b);
                if (power == num) {
                    return true;
                }
                if (power > num) {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * This ans not good when number is too big. it will took more time then required
     * 
     * @param a
     * @return
     */
    public boolean isPower1(int a) {
        if (a == 1) {
            return true;
        }
        int sqrt = (int) Math.sqrt(a);
        ArrayList<Integer> factors = sieve.sieve(a);
        if (factors.size() <= 0) {
            return false;
        }
        Map<Integer, Integer> factCount = new HashMap<>();
        int count;
        int numDivCount = a;
        for (int i = 0; i < factors.size(); i++) {
            if (numDivCount <= 1) {
                break;
            }
            count = 0;
            int fact = factors.get(i);
            while (numDivCount > 0) {
                if (numDivCount % fact == 0) {
                    count++;
                    numDivCount /= fact;
                } else {
                    break;
                }
            }
            factCount.put(fact, count);
        }
        int min = Integer.MAX_VALUE;
        for (Integer ele : factCount.values()) {
            if (ele != 0 && ele != 1 && min > ele) {
                min = ele;
            }
        }

        if (min == Integer.MAX_VALUE) {
            return false;
        }
        for (Integer ele : factCount.values()) {
            if (ele != 0) {
                if (ele == 1)
                    return false;
            } else if (ele % min != 0) {
                return false;
            }
        }
        return true;
    }
}
