package functionaltest;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 16-02-2016 Description:
 */
public class TestDoubleComparision {
    public static void main(String[] args) {
        float a = (float) 1.0;
        float b = (float) 0.0;
        for (int i = 1; i <= 10; i++) {
            b += 0.1;
        }
        if (a == b) {
            System.out.println("equal");
        } else {
            System.out.println("Not Equal");
        }
        System.out.println("a="+a+", b="+b);
        for (float i = (float) 0.1; i <= 2.0; i += 0.1) {
            System.out.print(i + " ");
            if (i == a) {
                System.out.println("found");
            }
        }
    }
}
