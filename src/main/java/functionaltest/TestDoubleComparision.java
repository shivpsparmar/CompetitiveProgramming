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
        // Not Equal
        if (a == b) {
            System.out.println("equal");
        } else {
            System.out.println("Not Equal");
        }
        // a=1.0, b=1.0000001
        System.out.println("a="+a+", b="+b);

        // 0.1 0.2 0.3 0.4 0.5 0.6 0.70000005 0.8000001 0.9000001 1.0000001 1.1000001 1.2000002 1.3000002 1.4000002
        // 1.5000002 1.6000003 1.7000003 1.8000003 1.9000003
        for (float i = (float) 0.1; i <= 2.0; i += 0.1) {
            System.out.print(i + " ");
            if (i == a) {
                //Never print Found
                System.out.println("found");
            }
        }

        System.out.println();
        long l = 130L;
        byte by = (byte) l;
        // From long to byte Long :130 == Byte:-126
        System.out.println("From long to byte Long :" + l + " == Byte:" + by);
    }
}
