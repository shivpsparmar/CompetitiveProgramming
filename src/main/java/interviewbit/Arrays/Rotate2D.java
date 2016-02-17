package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 08-02-2016.
 * 
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * You need to do this in place.
 * 
 * Note that if you end up using an additional array, you will only receive partial score.
 * 
 * Example:
 * 
 * If the array is
 * 
 * [ [1, 2], [3, 4] ] Then the rotated array becomes:
 * 
 * [ [3, 1], [4, 2] ]
 */
public class Rotate2D {
    public static void main(String[] args) {
        int num = 1;
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            a.add(new ArrayList<Integer>());
            for (int j = 0; j < 4; j++) {
                a.get(i).add(num);
                num++;
            }
        }
        new Rotate2D().rotate(a);
    }

    /**
     * Rotate given matrix by 90 degree clockwise
     * 
     * @param a
     */
    public void rotate(final ArrayList<ArrayList<Integer>> a) {
        // ArrayList<ArrayList<Integer>> ans= new ArrayList<>(a.size());
        // int[][] arr = new int[a.size()][a.size()];
        // for (int i = 0; i < a.size(); i++) {
        // for (int j = 0; j < a.size(); j++) {
        // arr[i][j] = a.get(i).get(j);
        // }
        // }

        int temp;
        int endIndex = a.size() - 1;
        for (int i = 0; i < a.size() - i; i++) {
            for (int j = i; j < a.size() - i - 1; j++) {
                temp = a.get(endIndex - j).get(i);
                a.get(endIndex - j).set(i, a.get(endIndex - i).get(endIndex - j));
                a.get(endIndex - i).set(endIndex - j, a.get(j).get(endIndex - i));
                a.get(j).set(endIndex - i, a.get(i).get(j));
                a.get(i).set(j, temp);
            }
        }
        // for (int i = 0; i < arr.length - i; i++) {
        // for (int j = i; j < arr.length - i-1; j++) {
        // temp = arr[arr.length - 1 - j][i];
        // arr[arr.length - 1 - j][i] = arr[arr.length - 1 - i][arr.length - 1 - j];
        // arr[arr.length - 1 - i][arr.length - 1 - j] = arr[j][arr.length - 1 - i];
        // arr[j][arr.length - i - 1] = arr[i][j];
        // arr[i][j] = temp;
        // }
        // }
        // for (int i = 0; i < arr.length; i++) {
        // ans.add(new ArrayList<Integer>(arr[i].length));
        // for (int j = 0; j < arr[i].length; j++) {
        // ans.get(i).add(arr[i][j]);
        // }
        // }
        // return ans;
        display(a);
    }

    private void display(ArrayList<ArrayList<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
