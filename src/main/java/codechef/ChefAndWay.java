package codechef;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 17-02-2016 Description:
 *
 * After visiting a childhood friend, Chef wants to get back to his home. Friend lives at the first street, and Chef
 * himself lives at the N-th (and the last) street. Their city is a bit special: you can move from the X-th street to
 * the Y-th street if and only if 1 <= Y - X <= K, where K is the integer value that is given to you. Chef wants to get
 * to home in such a way that the product of all the visited streets' special numbers is minimal (including the first
 * and the N-th street). Please, help him to find such a product. Input
 * 
 * The first line of input consists of two integer numbers - N and K - the number of streets and the value of K
 * respectively.
 * 
 * The second line consist of N numbers - A1, A2, ..., AN respectively, where Ai equals to the special number of the
 * i-th street. Output
 * 
 * Please output the value of the minimal possible product, modulo 1000000007. Constraints
 * 
 * 1 ≤ N ≤ 10^5 1 ≤ Ai ≤ 10^5 1 ≤ K ≤ N Example
 * 
 * Input: 4 2 1 2 3 4.
 * 
 * Output: 8
 */
public class ChefAndWay {
    public static void main(String[] args) {

        InputReader reader = new InputReader(System.in);
        int n = reader.readInt();
        int k = reader.readInt();
        int s[] = IOUtils.readIntArray(reader, n);
        if (s.length <= 0) {
            System.out.println(0);
        }
        Deque<Integer> deque= new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

        }
        
        int min[] = new int[s.length];
        for (int i = 0; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        int visited[] = new int[s.length];
        min[0] = s[0];
        visited[0] = 0;
        for (int i = 1; i < s.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0 && min[i] > s[i - j]) {
                    min[i] = s[i - j];
                    visited[i] = i - j;
                }
            }
        }
        int visitNode = n - 1;
        int result = 1;
        while (visitNode > 0) {
            result = (result * s[visitNode]) % 1000000007;
            visitNode = visited[visitNode];
        }
        System.out.println(result);
    }

    public static void printArray(int[] a) {
        for (int as : a) {
            System.out.print(as + " ");

        }
        System.out.println();
    }
}
