package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shivparmar01 on 08-02-2016.
 *
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending
 * order.
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Examples:
 * 
 * 1,2,3 → 1,3,2
 * 
 * 3,2,1 → 1,2,3
 * 
 * 1,1,5 → 1,5,1
 * 
 * 20, 50, 113 → 20, 113, 50 Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.
 * 
 * Warning : DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify you
 */
public class NextPerm {
    public static void main(String[] args) {

        final ArrayList<Integer> a = new ArrayList<Integer>() {
            {
                add(5);
                add(4);
                add(3);
                add(2);
                add(1);
            }
        };
        // List<Integer> al = Arrays.asList(444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758,
        // 675,
        // 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846,
        // 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274,
        // 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526,
        // 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52);
        // ArrayList<Integer> all = new ArrayList<>(al);
        // for (int i = 0; i < all.size(); i++) {
        // System.out.print(all.get(i) + " ");
        // }
        // System.out.println();
        // System.out.println(all.size());
        // System.out.println(all.size());
        new NextPerm().nextPermutation(a);
        System.out.println(a);
    }

    public void nextPermutation(ArrayList<Integer> a) {
        boolean solvBySorting = true;
        outer: for (int i = a.size() - 1; i >= 0; i--) {
            for (int j = a.size() - 1; j > i; j--) {
                if (a.get(i) < a.get(j)) {
                    int tem = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, tem);
                    Collections.sort(a.subList(i + 1, a.size()));
                    solvBySorting = false;
                    break outer;
                }
            }
        }
        if (solvBySorting) {
            Collections.sort(a);
        }
    }

    // boolean solv = false;
    // outer: for (int i = a.size() - 1; i >= 0; i--) {
    // int temp = a.get(i);
    // for (int j = i - 1; j >= 0; j--) {
    // if (temp > a.get(j)) {
    // a.set(i, a.get(j));
    // a.set(j, temp);
    // Collections.sort(a.subList(j + 1, a.size()));
    // solv = true;
    // break outer;
    // }
    // }
    // }
    // if (!solv) {
    // Collections.sort(a);
    // }

}
