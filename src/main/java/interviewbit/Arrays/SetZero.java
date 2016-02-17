package interviewbit.Arrays;

import java.util.ArrayList;

/**
 * Created by shivparmar01 on 11-02-2016. Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and
 * column to 0.
 * 
 * Do it in place.
 * 
 * Example
 * 
 * Given array A as
 * 
 * 1 0 1 1 1 1 1 1 1 On returning, the array A should be :
 * 
 * 0 0 0 1 0 1 1 0 1 Note that this will be evaluated on the extra memory used. Try to minimize the space and time
 * complexity.
 */
public class SetZero {
    public static void main(String[] args) {

    }

    /**
     * Work well if we have even boolean matrix too. In this algo first row and first column use as hash table to
     * identify , 'do row or column replace by series of zero?'
     * 
     * @param a
     */
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        if (a.size() <= 0) {
            return;
        }
        int n = a.size();
        int m = a.get(0).size();

        boolean rowFlag = false;
        boolean colFlag = false;
        for (int i = 0; i < n; i++) {
            if (a.get(i).get(0) == 0) {
                colFlag = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (a.get(0).get(i) == 0) {
                rowFlag = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(i).set(0, 0);
                    a.get(0).set(j, 0);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if (a.get(i).get(0) == 0) {
                for (int j = 1; j < m; j++) {
                    a.get(i).set(j, 0);
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (a.get(0).get(i) == 0) {
                for (int j = 1; j < n; j++) {
                    a.get(j).set(i, 0);
                }
            }
        }

        if (rowFlag) {
            for (int i = 0; i < n; i++) {
                a.get(i).set(0, 0);
            }
        }
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                a.get(0).set(i, 0);
            }
        }
    }

    /**
     * Set Zero in row and column where Zero found on i,j position this method use replacement by another number like 2
     * work fin only when integer matrix given, not work when we got boolean matrix.
     * 
     * @param A
     *            matrix
     */
    public void setZeroesByIB(ArrayList<ArrayList<Integer>> A) {
        int m, n;

        if (A == null)
            return;

        m = A.size();
        n = A.get(0).size();

        if (n == 0)
            return;

        for (int i = 0; i < m; i++) {
            boolean zero = false;
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 0)
                    zero = true;
            }

            if (zero)
                clearRow(A, i, m, n, 2);

        }

        for (int i = 0; i < n; i++) {
            boolean zero = false;
            for (int j = 0; j < m; j++) {
                if (A.get(j).get(i) == 0)
                    zero = true;
            }

            if (zero)
                clearCol(A, i, m, n, 2);

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 2)
                    A.get(i).set(j, 0);
            }
        }

    }

    public void clearRow(ArrayList<ArrayList<Integer>> A, int row, int m, int n, int value) {

        for (int i = 0; i < n; i++) {
            if (A.get(row).get(i) == 1)
                A.get(row).set(i, value);
        }
    }

    public void clearCol(ArrayList<ArrayList<Integer>> A, int col, int m, int n, int value) {
        for (int i = 0; i < m; i++) {
            if (A.get(i).get(col) == 1)
                A.get(i).set(col, value);
        }
    }
}
