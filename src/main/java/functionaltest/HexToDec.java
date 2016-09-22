package functionaltest;

/**
 * Created By : Shiv Pratap Singh Parmar
 * <p>
 * Created On : 04-03-2016 Description:
 */
public class HexToDec {
    public static void main(String[] args) {

        char input[] = {'C', 'F'};
        int ans[] = new HexToDec().hexToDec(input);
        for (int a : ans) {
            System.out.print(a);
        }
    }

    int[] hexToDec(char[] a) {
        int ans = 1;
        int len = length(a);
        int decValues[] = new int[len / 2];
        int i, j = 0;
        char part[] = new char[2];
        if (len <= 0) {
            return new int[0];
        }

        for (i = 1; i < len&&j<len/2; i += 2) {
            part[0] = a[i - 1];
            part[1] = a[i];
            decValues[j] = ConvertToDec(part);
            j++;
        }
        return decValues;
    }

    int length(char[] a) {
        return a.length;
    }

    int ConvertToDec(char[] part) {
        int ans = 0;
        int power = 0;
        int i;
        int len = length(part);
        for (i = len - 1; i >= 0; i--) {
            if (part[i] >= '0' && part[i] <= '9') {
                ans += (part[i] - 48) * power(16, power);
            } else if (part[i] == 'a' || part[i] == 'A') {
                ans += 10 * power(16, power);
            } else if (part[i] == 'b' || part[i] == 'B') {
                ans += 11 * power(16, power);
            } else if (part[i] == 'c' || part[i] == 'C') {
                ans += 12 * power(16, power);
            } else if (part[i] == 'd' || part[i] == 'D') {
                ans += 13 * power(16, power);
            } else if (part[i] == 'e' || part[i] == 'E') {
                ans += 14 * power(16, power);
            } else if (part[i] == 'f' || part[i] == 'F') {
                ans += 15 * power(16, power);
            }
            power++;
        }
        return ans;
    }

    long power(int base, int power) {
        int ans = 1;
        for (int i = 1; i <= power; i++) {
            ans *= base;
        }
        return ans;
    }
}
