package daiyun.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 桶排序
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {3, 65, 1, 3, 5, 2, 6, 68, 2};

        System.out.println(System.currentTimeMillis());
        simpleBucketSort(arr);
        System.out.println(System.currentTimeMillis());
        printArr(arr);
    }


    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    /**
     * 简单桶排序
     *
     * @param arr
     */
    public static void simpleBucketSort(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }

        int[] bucket = new int[arr[max] + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int p = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[p++] = j;
            }
        }
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radisSort(int[] arr) {
        int p = 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        int k = 0;
        while (k < arr.length) {

            for (int i = k; i < arr.length; i++) {
                int temp = arr[i];
                int indexP = 0;
                for (int j = 1; j < p; j++) {
                    temp = temp % 10;
                }
                indexP = temp % 10;
                buckets.get(indexP).add(arr[i]);
            }

            for (List<Integer> b : buckets) {
                Iterator<Integer> it = b.iterator();
                while (it.hasNext()) {
                    Integer temp = it.next();
                    if (temp < Math.pow(10, p)) {
                        arr[k++] = temp;
                        it.remove();
                    }
                }
            }

            for (List<Integer> b : buckets) {
                Iterator<Integer> it = b.iterator();
                while (it.hasNext()) {
                    arr[k++] = it.next();
                }
                b.clear();
            }
            p++;
        }

    }

    public void CountRadixSort(int[] arr) {
        
    }
}
