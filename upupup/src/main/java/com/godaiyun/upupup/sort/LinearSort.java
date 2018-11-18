package com.godaiyun.upupup.sort;

import java.util.ArrayList;

public class LinearSort {

  public static void main(String[] args) {
    int arr[] = {9, 3, 6, 23, 5, 67, 5, 6789, 34};
    bucketSort(arr);

    for (int i : arr) {
      System.out.println(i);
    }
  }


  /**
   * 桶排序
   *
   * @param arr
   */
  public static void bucketSort(int arr[]) {
    if (arr.length > 0) {

      int max = arr[0];
      for (int i = 1; i < arr.length; i++) {
        if (max < arr[i]) {
          max = arr[i];
        }
      }

      int sortArr[] = new int[max + 1];

      for (int i = 0; i < arr.length; i++) {
        sortArr[arr[i]] = sortArr[arr[i]] + 1;
      }

      int p = 0;
      for (int i = 0; i < sortArr.length; i++) {
        while (sortArr[i] > 0) {
          arr[p++] = i;
          sortArr[i] = sortArr[i] - 1;
        }
      }
    }

  }


 /* public static void radixSortA(String[] arr, int stringLen) {
    final int BUCKETS = 256;
    ArrayList<String>[] buckets = new ArrayList<String>[BUCKETS];

    for (int i = 0; i < BUCKETS; i++)
      buckets[i] = new ArrayList<>();

    for (int pos = stringLen - 1; pos >= 0; pos--) {
      for (String s : arr)
        buckets[s.charAt(pos)].add(s);

      int idx = 0;
      for (ArrayList<String> thisBucket : buckets) {
        for (String s : thisBucket)
          arr[idx++] = s;

        thisBucket.clear();
      }
    }
  }*/
}
