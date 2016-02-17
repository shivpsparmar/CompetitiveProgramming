package hackerearth;

import java.io.IOException;
import java.text.DecimalFormat;

public class TestClass {
    public static void main(String args[]) throws IOException {
        InputReader reader = new InputReader(System.in);
        int t = reader.readInt();
        double answer = 1;
        int n, r;
        for (int i = 0; i < t; i++) {
            n = reader.readInt();
            r = reader.readInt();
            answer *= calculateProbability(n, r);
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(answer));

    }

    private static double calculateProbability(double n, double r) {
        double sumOfNsqr = (n * (n + 1) * (2 * n + 1)) / 6;
        double a = Math.pow(r, 2) / sumOfNsqr;
        double p = 0;
        for (int i = 1; i <= n; i++) {
            double m = ((i * i) / (r * r));
            p += ((a * m) * (i / r));
        }
        return p;
    }
}
