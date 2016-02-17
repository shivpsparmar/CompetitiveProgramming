package interviewbit.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created By : Shiv Pratap Singh Parmar
 * 
 * Created On : 12-02-2016 Description:
 * 
 * You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in
 * linear time and constant additional space.
 * 
 * If so, return the integer. If not, return -1.
 * 
 * If there are multiple solutions, return any one.
 * 
 * Example :
 * 
 * Input : [1 2 3 1 1] Output : 1 1 occurs 3 times which is more than 5/3 times.
 */
public class Repeat3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1000545, 1000038, 1000647, 1000038, 1000562, 1000038, 1000586, 1000487,
            1000951, 1000226, 1000038, 1000145, 1000038, 1000761, 1000196, 1000038, 1000821, 1000829, 1000038, 1000570,
            1000846, 1000038, 1000178, 1001000, 1000038, 1000568, 1000278, 1000734, 1000048, 1000038, 1000002, 1000271,
            1000388, 1000315, 1000816, 1000038, 1000038, 1000846, 1000305, 1000853, 1000383, 1000116, 1000797, 1000279,
            1000038, 1000038, 1000049, 1000108, 1000789, 1000240, 1000201, 1000506, 1000429, 1000857, 1000649, 1000898,
            1000211, 1000000, 1000178, 1000038, 1000569, 1000695, 1000451, 1000159, 1000038, 1000038, 1000038, 1000129,
            1000038, 1000038, 1000904, 1000038, 1000038, 1000902, 1000525, 1000038, 1000166, 1000038, 1000765, 1000038,
            1000561, 1000417, 1000523, 1000668, 1000296, 1000038, 1000038, 1000038, 1000461, 1000654, 1000924, 1000985,
            1000038, 1000426, 1000038, 1000038, 1000038, 1000904, 1000775, 1000148, 1000961, 1000038, 1000038, 1000038,
            1000833, 1000332, 1000038, 1000038, 1000512, 1000322, 1000592, 1000524, 1000788, 1000057, 1000497, 1000625,
            1000599, 1000484, 1000038, 1000747, 1000457, 1000111, 1000038, 1000038, 1000493, 1000287, 1000007, 1000695,
            1000344, 1000098, 1000038, 1000191, 1000038, 1000576, 1000481, 1000488, 1000199, 1000038, 1000663, 1000176,
            1000038, 1000521, 1000721, 1000728, 1000247, 1000038, 1000038, 1000460, 1000644, 1000038, 1000497, 1000966,
            1000431, 1000038, 1000975, 1000063, 1000580, 1000669, 1000038, 1000038, 1000492, 1000038, 1000038, 1000529,
            1000553, 1000333, 1000038, 1000341, 1000569, 1000862, 1000017, 1000532, 1000571, 1000508, 1000402, 1000285,
            1000611, 1000210, 1000646, 1000110, 1000038, 1000553, 1000273, 1000729, 1000038, 1000038, 1000720, 1000400,
            1000038, 1000983, 1000038, 1000766, 1000038, 1000180, 1000494, 1000765, 1000136, 1000038, 1000029, 1000246,
            1000991, 1000038, 1000759, 1000038, 1000038, 1000045, 1000038, 1000648, 1000038, 1000038, 1000694, 1000914,
            1000990, 1000038, 1000038, 1000758, 1000435, 1000038, 1000554, 1000038, 1000452, 1000156, 1000038, 1000322,
            1000828, 1000868, 1000038, 1000973, 1000991, 1000464, 1000294, 1000633, 1000038, 1000582, 1000229, 1000285,
            1000038, 1000038, 1000086, 1000038, 1000989, 1000038, 1000038, 1000157, 1000307, 1000369, 1000300, 1000038,
            1000038, 1000038, 1000244, 1000038, 1000038, 1000222, 1000458, 1000038, 1000523, 1000434, 1000316, 1000038,
            1000256, 1000038, 1000695, 1000038, 1000469);
        // list = Collections.unmodifiableList(list);
        System.out.println(new Repeat3().repeatedNumber(list));
    }

    /**
     * It is important to note that if at a given time, you have 3 distinct element from the array, if you remove them
     * from the array, your answer does not change.
     * 
     * Assume that we maintain 2 elements with their counts as we traverse along the array.
     * 
     * When we encounter a new element, there are 3 cases possible :
     * 
     * We don’t have 2 elements yet. So add this to the list with count as 1.
     * 
     * This element is different from the existing 2 elements. As we said before, we have 3 distinct numbers now.
     * Removing them does not change the answer. So decrement 1 from count of 2 existing elements. If their count falls
     * to 0, obviously its not a part of 2 elements anymore.
     * 
     * The new element is same as one of the 2 elements. Increment the count of that element.
     * 
     * Consequently, the answer will be one of the 2 elements left behind. If they are not the answer, then there is no
     * element with count > N / 3
     * 
     * @param a
     * @return
     */
    public int repeatedNumber(final List<Integer> a) {
        class Count {
            int count;
            int value;

            public Count() {
                value = 0;
                count = 0;
            }
        }
        int n = a.size();
        int minLenght = n / 3;
        Count[] counter = new Count[2];
        for (int i = 0; i < counter.length; i++) {
            counter[i] = new Count();
        }

        for (int i = 0; i < n; i++) {
            int ele = a.get(i);
            boolean found = false;
            for (int j = 0; j < counter.length; j++) {
                if (counter[j].count != 0 && ele == counter[j].value) {
                    counter[j].count++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                int index = counter[0].count <= counter[1].count ? 0 : 1;
                counter[index].value = ele;
                counter[index].count = 1;
            }

        }

        for (int i = 0; i < counter.length; i++) {
            int counting = 0;
            for (int j = 0; j < n; j++) {
                if (counter[i].value == a.get(j)) {
                    counting++;
                    if (counting > minLenght) {
                        return a.get(i);
                    }
                }
            }
        }
        return -1;
    }

    // This method works in O(1) space and O(n) time

    /**
     * This method works fine if list is modifiable Works fine in O(n*log n) and o(1) space First, sort all elements So
     * overall, time complexity of this method is O(nLogn) + O(n) which is O(nLogn).
     * 
     * However, a linear solution is needed here.
     * 
     * @param a
     * @return
     */
    public int repeatedNumber1(final List<Integer> a) {
        if (a.size() < 1) {
            return -1;
        }
        if (a.size() == 1) {
            return a.get(0);
        }

        int n = a.size();
        Collections.sort(a);
        int minOccur = n / 3;
        int count = 0;
        int pre = a.get(0);
        int current;
        for (int i = 0; i < a.size(); i++) {
            current = a.get(i);
            if (pre == current) {
                count++;
                if (count > minOccur) {
                    return pre;
                }
            } else {
                pre = current;
                count = 1;
            }
        }

        System.out.println(a);
        return -1;
    }
}
