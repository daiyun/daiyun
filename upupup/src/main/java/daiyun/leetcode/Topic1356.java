package daiyun.leetcode;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.Semaphore;

/**
 *
 */
public class Topic1356 {

    public static void main(String[] args) {

        Solution a = new Solution();

        a.sortByBits(new int[]{1, 2, 3, 4});
    }

    static class Solution {
        public int[] sortByBits(int[] arr) {
            if (arr == null || arr.length < 2) {
                return arr;
            }
            Map<Integer, Integer> hanmingCount = new HashMap<>();
            int[] res = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                int count = hanming(arr[i]);

                int j = i;
                for (; j > 0; ) {
                    if (hanmingCount.get(res[j - 1]) > count ||
                            (hanmingCount.get(res[j - 1]) == count && res[j - 1] > arr[i])) {
                        res[j] = res[j - 1];
                        j--;
                    } else {
                        break;
                    }
                }

                res[j] = arr[i];
                hanmingCount.put(arr[i], count);
            }

            return res;
        }

        public int hanming(int i) {
            //步骤1
            i = (i & 0x55555555) + ((i >> 1) & 0x55555555);
            //步骤2
            i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
            //步骤3
            i = (i & 0x0F0F0F0F) + ((i >> 4) & 0x0F0F0F0F);
            //步骤4
            i = (i * (0x01010101) >> 24);
            return i;
        }
    }


}
