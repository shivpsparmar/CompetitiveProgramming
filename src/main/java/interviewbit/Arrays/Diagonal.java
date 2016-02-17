package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 05-02-2016. Give a N*N square matrix, return an array of its anti-diagonals. Look at the
 * example for more details.
 * 
 * Example:
 *
 * Input:
 * 
 * 1 2 3 4 5 6 7 8 9
 * 
 * Return the following :
 * 
 * [ [1], [2, 4], [3, 5, 7], [6, 8], [9] ]
 *
 * Input : 1 2 3 4
 * 
 * Return the following :
 * 
 * [ [1], [2, 3], [4] ]
 */
public class Diagonal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < 3; i++) {
            ans.add(new ArrayList<Integer>());
            for (int j = 0; j < 3; j++) {
                ans.get(i).add(number);
                number++;
            }
        }
        System.out.println(new Diagonal().diagonal(ans));
    }

    /**
     * Return list of diagonal
     * @param a
     * @return
     */
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int alIndex = 0;
        int x = 0;
        int y = 0;
        while (x < a.size()) {
            ans.add(new ArrayList<Integer>());
            for (int j = x, k = y; j <= y && k >= x; j++, k--) {
                ans.get(alIndex).add(a.get(j).get(k));
            }
            if (y == a.size() - 1) {
                x++;
            } else {
                y++;
            }
            alIndex++;
        }
        return ans;
    }
}
