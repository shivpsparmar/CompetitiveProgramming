package interviewbit.math;

import java.util.ArrayList;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 15-02-2016 Description: Given a number N, find all prime numbers upto N ( N included ).
 * 
 * Example:
 * 
 * if N = 7,
 * 
 * all primes till 7 = {2, 3, 5, 7}
 * 
 * Make sure the returned array is sorted.
 */
public class Sieve {
    public static void main(String[] args) {
        // System.out.println(new Sieve().sieve(999999));
        System.out.println(Sieve.isPrime(93298));
    }

    public static boolean isPrime(final int i) {
        if (i == 2) {
            return true;
        }
        if (i < 2 || i % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(i);
        for (int j = 3; j <= sqrt; j += 2) {
            if (i % j == 0)
                return false;
        }
        return true;
    }

    /**
     * Find this method in sieve algorithm for prime number
     *
     * @param a
     *            the upper bound to prime numbers
     * @return list of prime numbers till given number "a"
     */
    public ArrayList<Integer> sieve(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean primes[] = new boolean[a - 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                int primNum = i + 2;
                if (isPrime(primNum)) {
                    for (int j = i + primNum; j < primes.length; j += primNum) {
                        primes[j] = false;
                    }
                }
            }
        }
        for (int i = 0; i < primes.length; i++) {
            if (primes[i])
                ans.add(i + 2);
        }
        return ans;
    }

    /**
     * Not a good approach because it wil work on |n root n|
     * 
     * @param a
     * @return
     */
    public ArrayList<Integer> getAllPrimesTill(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (a < 2) {
            return ans;
        }
        ans.add(2);
        if (a == 2) {
            return ans;
        }
        for (int i = 3; i < a; i = i + 2) {
            if (isPrime(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
