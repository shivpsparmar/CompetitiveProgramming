package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shivparmar01 on 10-02-2016.
 * 
 * Given an array of integers, sort the array into a wave like array and return it, In other words, arrange the elements
 * into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 * 
 * Example
 * 
 * Given [1, 2, 3, 4]
 * 
 * One possible answer : [2, 1, 4, 3] Another possible answer : [4, 1, 3, 2]
 * 
 * NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. possible answer : [2,
 * 1, 4, 3]
 */
public class Wave {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        // ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(a);
        for (int i = 1; i < a.size(); i += 2) {
            int temp = a.get(i - 1);
            a.set(i - 1, a.get(i));
            a.set(i, temp);
        }
        return a;
    }
}
