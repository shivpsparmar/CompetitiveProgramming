package hackerearth;

// uncomment this if you want to read input.
class ShilAndLuckyString {
    public static void main(String args[]) throws Exception {
        // Read input from stdin and provide input before running

        InputReader reader = new InputReader(System.in);
        String line = reader.readString();
        int N = Integer.parseInt(line);
        String str;
        int f, s, t;
        int equal = 0;
        int sHalfCopy[] = new int[128];
        int fHalfCopy[] = new int[128];
        equal = 0;
        char strArray[] = new char[N];
        for (int i = 0; i < N; i++) {
            strArray[i] = (char) reader.read();
        }

        for (int i = 0; i < strArray.length / 2; i++) {
            fHalfCopy[strArray[i]]++;
        }
        for (int i = strArray.length / 2; i < strArray.length; i++) {
            sHalfCopy[strArray[i]]++;
        }
        for (int i = 0; i < fHalfCopy.length; i++) {
            equal += fHalfCopy[i] < sHalfCopy[i] ? fHalfCopy[i] : sHalfCopy[i];
        }
        for (int i = 0; i < fHalfCopy.length; i++) {
            while (fHalfCopy[i] > 0) {
                int j = i + 1;
                for (; j < sHalfCopy.length; j++) {
                    if (sHalfCopy[j] > 0) {
                        fHalfCopy[i]--;
                        sHalfCopy[j]--;
                        break;
                    }
                }
                if (j == 128) {
                    break;
                }
            }
        }
        int option = 0;
        int aType = sHalfCopy[97] - (fHalfCopy[97] < sHalfCopy[97] ? fHalfCopy[97] : sHalfCopy[97]);
        int zType = fHalfCopy[122] - (fHalfCopy[122] < sHalfCopy[122] ? fHalfCopy[122] : sHalfCopy[122]);

        for (int i = 0; i < fHalfCopy.length; i++) {
            option += fHalfCopy[i] + sHalfCopy[i];
        }

        f = (option / 2);
        if(zType==aType){
            f+=zType;
        }
        s = (strArray.length - option) / 2;
        t = strArray.length / 2 - equal;
        System.out.println(f < s ? f < t ? f : t : s < t ? s : t);
    }
}
