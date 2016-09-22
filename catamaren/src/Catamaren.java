import java.util.Scanner;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 09-05-2016 Description:
 */
public class Catamaren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output= new StringBuilder();
        int t=0;
        if (scanner.hasNext())
           t=scanner.nextInt();
        while (t>0) {
            int MAX_LENGTH = 9;
            int inputs[] = new int[10];
            inputs[0] = 0;

            for (int i = 1; i <= MAX_LENGTH; i++) {
                if (scanner.hasNext())
                    inputs[i] = scanner.nextInt();
            }
            output.append(getMinSequence(inputs)).append("\n");
            --t;
        }
        System.out.println(output.toString());
    }

    public static String getMinSequence(int inputs[]) {
        int solution[] = new int[5];
        int obt[] = new int[5];
        initialize(solution);
        initialize(obt);
        solv(inputs, solution, obt);
        return printSolution(obt);
    }

    private static void initialize(int balls[]) {
        balls[1] = Integer.MAX_VALUE;
    }

    private static void solv(int inputs[], int solution[], int obt[]) {
        int i = 1;
        while (i <= 3) {
            if (isNotMinimum(i, solution)) {
                setValueOfa(i, solution);
                if (isSolvable(solution)) {
                    getSolved(inputs, solution);
                    if (solution[1] < obt[1]) {
                        for (int j = 1; j <= 4; j++) {
                            obt[j] = solution[j];
                        }
                    }
                } else {
                    solv(inputs, solution, obt);
                }
                reset(solution);
            }
            i++;
        }
    }

    private static boolean isNotMinimum(int a, int s[]) {
        for (int i = 2; i <= 4; i++) {
            if (s[i] == a) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSolvable(int sol[]) {
        for (int i = 2; i <= 4; i++) {
            if (sol[i] == 0) {
               return false;
            }
        }
        return true;
    }

    private static void setValueOfa(int a, int s[]) {
        int i = 2;
        while (i <= 4 && (s[i] != 0)) {
            i++;
        }
        s[i] = a;
    }

    private static void getSolved(int vec[], int sol[]) {
        int j = 0;
        sol[1] = 0;
        for (int i = 1; i <= 9; i++) {
            if (i - (3 * j) != sol[j + 2]) {
                sol[1] = sol[1] + vec[i];
            }
            if (i % 3 == 0) {
                j++;
            }
        }
    }

    private static void reset(int s[]) {
        int i = 2;
        if (s[4] == 0) {
            while (i <= 3 && s[i] != 0) {
                if (s[i + 1] == 0) {
                    s[i] = 0;
                }
                i++;
            }
        } else {
            s[4] = 0;
        }
    }

    private static String printSolution(int s[]) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i <= 4; i++) {
            switch (s[i]) {
                case 1:
                    result.append("W");
                    break;
                case 2:
                    result.append("B");
                    break;
                case 3:
                    result.append("S");
                    break;
            }
        }
        result.append(" ").append(s[1]);
        return result.toString();
    }
}
