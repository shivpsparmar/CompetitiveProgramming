package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * Example:
 * 
 * Given n = 3,
 * 
 * You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class Spiral2 {
    public static void main(String[] args) {
        System.out.println(new Spiral2().generateMatrix(5));
    }

    /**
     * Calculate spiral matrix till given number
     * @param a the number
     * @return the spiral matrix
     */
    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        int arr[][] = new int[a][a];
        int iBoundaryLeft = 0;
        int iBoundaryRight = a - 1;
        int jBoundaryLeft = 0;
        int jBoundaryRight = a - 1;
        int number = 1;
        boolean lTor = true;
        boolean rTol = false;
        boolean uToDown = false;
        boolean dToUp = false;
        int sqr = a * a;
        while (iBoundaryLeft <= jBoundaryRight && number <= sqr) {

            if (lTor)
                for (int k = iBoundaryLeft; k <= jBoundaryRight; k++) {
                    arr[iBoundaryLeft][k] = number;
                    number++;
                    if (k == iBoundaryRight) {
                        iBoundaryLeft++;
                        lTor = false;
                        uToDown = true;
                    }
                }
            if (uToDown)
                for (int k = iBoundaryLeft; k <= jBoundaryRight; k++) {
                    arr[k][jBoundaryRight] = number;
                    number++;
                    if (k == jBoundaryRight) {
                        jBoundaryRight--;
                        uToDown = false;
                        rTol = true;
                    }
                }
            if (rTol)
                for (int k = jBoundaryRight; k >= jBoundaryLeft; k--) {
                    arr[iBoundaryRight][k] = number;
                    number++;
                    if (k == jBoundaryLeft) {
                        iBoundaryRight--;
                        rTol = false;
                        dToUp = true;
                    }
                }
            if (dToUp)
                for (int k = iBoundaryRight; k >= iBoundaryLeft; k--) {
                    arr[k][jBoundaryLeft] = number;
                    number++;
                    if (k == iBoundaryLeft) {
                        jBoundaryLeft++;
                        dToUp = false;
                        lTor = true;
                    }
                }
        }

        for (int k = 0; k < a; k++) {
            ans.add(new ArrayList<Integer>());
            for (int l = 0; l < a; l++) {
                ans.get(k).add(arr[k][l]);
            }
        }
        return ans;
    }
}
