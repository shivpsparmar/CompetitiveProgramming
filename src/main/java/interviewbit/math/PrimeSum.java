package interviewbit.math;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 16-02-2016 Description: Given an even number ( greater than 2 ), return two prime numbers whose sum will
 * be equal to given number.
 * 
 * NOTE A solution will always exist. read Goldbach’s conjecture
 * 
 * Example:
 * 
 * 
 * Input : 4 Output: 2 + 2 = 4
 * 
 * If there are more than one solutions possible, return the lexicographically smaller solution.
 * 
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
 * 
 * [a, b] < [c, d]
 * 
 * If a < c OR a==c AND b < d.
 */
public class PrimeSum {
    private Sieve sieve;

    public PrimeSum(final Sieve sieve) {
        this.sieve = sieve;
    }

    public static void main(String[] args) {
        System.out.println(new PrimeSum(new Sieve()).primesum(15));
    }

    /**
     * return two prime numbers whose sum equal to given number.
     * @param a the number
     * @return two primes
     */
    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<Integer> primes = sieve.sieve(a);

        int primeSize = primes.size();
        for (int i = 0; i < primeSize; i++) {
            int ele = primes.get(i);
            if (Collections.binarySearch(primes, a - ele) >= 0) {
                ans.add(ele);
                ans.add(a - ele);
                break;
            }
        }
        return ans;
    }
}
