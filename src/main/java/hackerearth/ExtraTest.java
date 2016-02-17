package hackerearth;

/**
 * Created by shivparmar01 on 03-02-2016.
 */
public class ExtraTest {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 3, 4, 5, 6 };
        printArray(arr);
        int sec[] = arr;
        sec[2] = 18;
        printArray(sec);
        printArray(arr);
        sec[1] = 0;
        int t[]=arr;
        printArray(arr);
        printArray(t);
    }

    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
