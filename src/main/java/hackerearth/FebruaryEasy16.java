package hackerearth;

import java.text.DecimalFormat;

/**
 * Created by shivparmar01 on 03-02-2016.
 */
public class FebruaryEasy16 {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int rGauge = reader.readInt();
        double probSum = 0;
        double sufaceProb[][] = new double[rGauge + 1][];
        double sufaceX[][] = new double[rGauge + 1][];
        double n[] = new double[rGauge + 1];
        double r[] = new double[rGauge + 1];
        for (int nGauge = 1; nGauge <= rGauge; nGauge++) {
            probSum = 0;
            n[nGauge] = reader.readDouble();
            r[nGauge] = reader.readDouble();

            sufaceProb[nGauge] = new double[(int) n[nGauge] + 1];
            sufaceX[nGauge] = new double[(int) n[nGauge] + 1];
            for (int nSurf = 1; nSurf <= n[nGauge]; nSurf++) {
                probSum += (nSurf / r[nGauge]) * (nSurf / r[nGauge]);
            }
            for (int i = 1; i <= n[nGauge]; i++) {
                sufaceX[nGauge][i] = (double) i / r[nGauge];
                sufaceProb[nGauge][i] = (sufaceX[nGauge][i] * sufaceX[nGauge][i]) / probSum;
            }

        }

        // for (int i = 1; i < sufaceX.length; i++) {
        // for (int j = 1; j < sufaceX[i].length; j++) {
        // System.out.print(sufaceX[i][j]+ " ");
        // }
        // System.out.println();
        // }
        //
        // for (int i = 1; i < sufaceProb.length; i++) {
        // for (int j = 1; j < sufaceProb[i].length; j++) {
        // System.out.print(sufaceProb[i][j]+ " ");
        // }
        // System.out.println();
        // }

        double answer = 0;
        for (int i = 1; i < sufaceProb.length; i++) {
            for (int j = i + 1; j < sufaceProb.length; j++) {
                for (int k = 1; k < sufaceProb[i].length; k++) {
                    for (int l = 1; l < sufaceProb[j].length; l++) {
                        answer += (sufaceProb[i][k] * sufaceProb[j][l] * sufaceX[i][k] * sufaceX[j][l]);
                    }
                }
            }
        }

        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(answer));
    }
}
