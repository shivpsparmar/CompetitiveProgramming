public class BinaryCode {

    public String[] decode(String message) {
        if (message.length() <= 0) {
            return new String[] { "NONE", "NONE" };
        }
        if (message.length() == 1) {
            if (message.charAt(0) >= '2')
                return new String[] { "NONE", "NONE" };
            else if (message.charAt(0) == '0')
                return new String[] { "0", "NONE" };
            else
                return new String[] { "NONE", "1" };

        }
        String result[] = new String[2];

        // for first case
        StringBuilder ans = new StringBuilder();
        ans.append('0');
        int q[] = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            q[i] = message.charAt(i) - 48;
        }
        int p[] = new int[message.length()];
        int p2[] = new int[message.length()];
        p[0] = 0;
        p2[0] = 1;
        p[1] = q[0] - p[0];
        p2[1] = q[0] - p2[0];
        boolean pp1 = true;
        boolean pp2 = true;
        if (p[0] > 1 || p[1] > 1) {
            result[0] = "NONE";
            pp1 = false;
        }
        if (p2[0] > 1 || p2[1] > 1) {
            result[1] = "NONE";
            pp2 = false;
        }

        for (int i = 2; i < p.length; i++) {
            if ((!pp1) && (!pp2)) {
                break;
            }
            if (pp1) {
                p[i] = q[i - 1] - p[i - 1] - p[i - 2];
                if (p[i] > 1) {
                    result[0] = "NONE";
                    pp1 = false;
                }
            }
            if (pp2) {
                p2[i] = q[i - 1] - p2[i - 1] - p2[i - 2];
                if (p2[i] > 1) {
                    result[1] = "NONE";
                    pp2 = false;
                }
            }
        }

        if (p[p.length - 1] + p[p.length - 2] != q[q.length - 1]){
            pp1=false;
            result[0]="NONE";
        }
        if (p2[p2.length - 1] + p2[p2.length - 2] != q[q.length - 1]){
            pp2=false;
            result[1]="NONE";
        }
            if (pp1) {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < p.length; i++) {
                    s.append(p[i]);
                }
                result[0] = s.toString();
            }
        if (pp2) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < p2.length; i++) {
                s.append(p2[i]);
            }
            result[1] = s.toString();
        }
        return result;
    }
}
