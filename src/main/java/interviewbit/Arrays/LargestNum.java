package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example:

 Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.

 A complete solution is make Node class with number override compare method and add both case comparison in it.

 * Created by shivparmar01 on 05-02-2016.
 */
public class LargestNum {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>() {
            {
                add(98);
                add(7);
                add(777);
                add(78);
                add(789);
                add(07);
                add(999999999);
                add(70);
                add(79);
            }
        };
        // int[] arr = new int[] { 170, 480, 735, 896, 634, 844, 1, 610, 446, 591, 935, 802, 383, 8, 443, 247, 124, 461,
        // 317, 457, 48, 886, 420, 473, 973, 464, 203, 288, 785, 703, 935, 7, 987, 48, 692, 633, 597, 857, 139,
        // 733, 692, 68, 434, 587, 489, 517, 305, 432, 577, 335, 586, 34, 659, 491, 310, 857, 256, 856, 257, 877,
        // 209, 979, 653, 646, 2, 65, 858, 779, 372, 116, 404, 268, 364, 351, 866, 824, 947, 960, 91, 691, 492,
        // 312, 609, 915, 579, 476, 248, 192 };
//        int arr[] = new int[] { 931, 94, 209, 448, 716, 903, 124, 372, 462, 196, 715, 802, 103, 740, 389, 872, 615,
//                638, 771, 829, 899, 999, 29, 163, 342, 902, 922, 312, 326, 817, 288, 75, 37, 286, 708, 589, 975, 747,
//                743, 699, 743, 954, 523, 989, 114, 402, 236, 855, 323, 79, 949, 176, 663, 587, 322 };
        int[] arr= new int[]{121, 12};
        ArrayList<Integer> arrayList = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        System.out.println(new LargestNum().largestNumber(arrayList));
    }

    /**
     * Return Largest possible number
     * @param a list of number
     * @return string containing Largest number formed by given numbers
     */
    public String largestNumber(final List<Integer> a) {
        String ans = new String();

        int[] arr = new int[a.size()];
        int index = 0;
        for (Integer ai : a) {
            arr[index] = ai;
            index++;
        }

        insertionSort(arr);
        return trimHeadingZero(convertToString(arr));
    }

    private void insertionSort(int[] a) {
        int i = 1;
        while (i < a.length) {
            int j = i - 1;
            int temp = a[i];
            // if a[j] big than temp then continue swap
            while (j >= 0 && !compare(a[j], temp)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
            i++;
        }
    }

    private boolean myCompare(int i, int temp){
        long it, ti;
        StringBuilder st= new StringBuilder();
        st.append(i).append(temp);
        it=Long.parseLong(st.toString());
        st= new StringBuilder();
        ti=Long.parseLong(st.append(temp).append(i).toString());
        return  it>ti;
    }
    
    private boolean compare(int i, int temp) {
        String strI = new String("" + i);
        String strTemp = new String("" + temp);
        int max = strI.length() > strTemp.length() ? strI.length() : strTemp.length();
        int min = strI.length() < strTemp.length() ? strI.length() : strTemp.length();

        int diff = strI.substring(0, min).compareTo(strTemp.substring(0, min));
        if (diff < 0) {
            return false;
        } else {
            if (diff == 0) {
                if (strI.length() == strTemp.length()) {
                    return false;
                } else if (strI.length() > strTemp.length()) {
                    for (int j = min; j < strI.length(); j++) {
                        if ((strI.charAt(j) != strI.charAt(0))) {
                            return strI.charAt(j) > strI.charAt(0) ? true : false;
                        }
                        else if(j==strI.length()-1){
                            return (strI+strTemp).compareTo(strTemp+strI)>0;
                        }
                    }
                } else {
                    for (int j = min; j < strTemp.length(); j++) {
                        if (strTemp.charAt(j) != strTemp.charAt(0)) {
                            return strTemp.charAt(j) > strTemp.charAt(0) ? false : true;
                        }
                        else if(j==strTemp.length()-1){
                            return (strI+strTemp).compareTo(strTemp+strI)>0;
                        }
                    }
                }
            } else {
                return true;
            }
        }
        return true;
    }

    private String convertToString(int[] arr) {
        String str = new String();
        for (int i = 0; i < arr.length; i++) {
            str += "" + arr[i];
        }
        return str;
    }

    private void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (checkForBig(arr, i, j)) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private boolean checkForBig(int[] arr, int i, int j) {

        int tempArray[] = new int[arr.length];
        for (int k = 0; k < arr.length; k++) {
            tempArray[k] = arr[k];
        }
        int temp = tempArray[i];
        tempArray[i] = tempArray[j];
        tempArray[j] = temp;

        return convertToString(arr).compareTo(convertToString(tempArray)) > 0 ? false : true;
    }



    public String largestNumber1(final List<Integer> a) {
        int highest = 0;
        for (int i = 0; i < a.size(); i++) {
            int hi = a.get(i);
            if (highest < hi) {
                highest = hi;
            }
        }
        ArrayList<String> inStr = new ArrayList<String>(a.size());
        for (Integer i : a) {
            inStr.add(String.valueOf(i));
        }

        int maxChar = new String("" + highest).length();
        for (int i = 0; i < inStr.size(); i++) {
            String temp = inStr.remove(i);
            if (temp.length() < maxChar) {
                for (int j = 0; j < maxChar - temp.length(); j++) {
                    temp = temp + "A";
                }
            }
            inStr.add(i, temp);
        }
        Collections.sort(inStr);
        StringBuilder ans = new StringBuilder();
        String lastAddes = new String();
        for (int i = inStr.size() - 1; i >= 0; i--) {
            lastAddes = getBig(ans, lastAddes, removeA(inStr.get(i)));
        }
        return trimHeadingZero(ans.toString());
    }

    private String trimHeadingZero(String s) {
        if (s.length() <= 0) {
            return s;
        }
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) != '0') {
                return s.substring(j, s.length());
            }
        }
        return new String("0");
    }

    private String getBig(final StringBuilder ans, final String lastAdded, final String s) {
        if (ans.length() <= 0) {
            ans.append(s);
            return s;
        }
        if (s.length() <= 0) {
            return new String();
        }
        if (lastAdded.length() <= 0) {
            ans.append(s);
            return s;
        } else {
            if ((lastAdded + s).compareTo(s + lastAdded) > 0) {
                ans.append(s);
                return s;
            } else {
                ans.replace(ans.lastIndexOf(lastAdded), ans.length(), "");
                ans.append(s + lastAdded);
                return lastAdded;
            }
        }
    }

    private String removeA(final String s) {
        return s.replace("A", "");
    }
}
