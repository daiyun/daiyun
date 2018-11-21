
package daiyun.sort;

import java.util.ArrayList;
import java.util.List;

public class ComparsionSortUtils {

  public static void main(String[] args) {
/*    List<Integer> list = new ArrayList<Integer>();
    list.add(456);
    list.add(2134);
    list.add(56);
    list.add(4);
    list.add(2);
    list.add(3);
    list.add(45);
    list.add(1);
    for (Integer i : quickSort1(list)) {
      System.out.println(i);
    }*/
    int arr[] = {456, 5, 56, 4, 2, 3, 45, 1};
    int arr1[] = {1, 5, 67, 345, 3456, 34534, 42342};
    int arr3[] = {2, 5, 24, 1, 3, 48};
    int arr4[] = {2, 3, 24, 48, 56, 1, 2, 4, 7, 12, 59};
//    merge2(arr3, 0, 2, 5);
//    mergeSort(arr4, 0, 9);


//    SortUtil.shellSort(arr4);
//    SortUtil.shellSort(arr3);
//    SortUtil.selectSort(arr4);
    ComparsionSortUtils.printArr(arr4);


//    ExchangeSort.maoPaoSort2(arr);
//    ComparsionSortUtils.printArr(mergySort(arr1, arr3));
  }

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ",");
    }
  }

  /**
   * 交换排序
   * 简单交换排序（冒泡排序）
   *
   * @param arr
   */
  public static void simpleExchangeSort(int arr[]) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  /**
   * 交换排序
   * 快速排序:方式一使用迭代，使用额外的空间
   *
   * @param arr
   * @return
   */
  public static List<Integer> quickSort1(List<Integer> arr) {
    if (arr.size() > 1) {
      List<Integer> smaill = new ArrayList<Integer>();
      List<Integer> equal = new ArrayList<Integer>();
      List<Integer> big = new ArrayList<Integer>();
      Integer p = arr.get(arr.size() / 2);
      for (int i = 0; i < arr.size(); i++) {
        if (arr.get(i) > p) {
          big.add(arr.get(i));
        } else if (arr.get(i) < p) {
          smaill.add(arr.get(i));
        } else {
          equal.add(arr.get(i));
        }
      }
      smaill = quickSort1(smaill);
      big = quickSort1(big);
      arr.clear();
      arr.addAll(smaill);
      arr.addAll(equal);
      arr.addAll(big);
      return arr;
    }
    return arr;
  }


  /**
   * 交换排序
   * 快速排序：方式二使用迭代，使用数组内部交换
   *
   * @param arr
   * @param start
   * @param end
   */
  public static void quickSort2(int arr[], int start, int end) {
    if (start < end) {
      int mid = oneQuickSort(arr, start, end);
      quickSort2(arr, start, mid - 1);
      quickSort2(arr, mid + 1, end);
    }
  }

  /**
   * 数组内部一次交换
   *
   * @param arr
   * @param start
   * @param end
   * @return
   */
  private static int oneQuickSort(int[] arr, int start, int end) {
    int temp = arr[start];
    while (start < end) {
      while (start < end && temp < arr[end]) {
        end--;
      }
      arr[start] = arr[end];

      while (start < end && temp > arr[start]) {
        start++;
      }
      arr[end] = arr[start];
    }
    arr[start] = temp;
    return start;
  }

//======================================================================================================================

  /**
   * 插入排序
   * 简单插入排序
   *
   * @param arr
   */
  public static void simpleInsertSort(int arr[]) {
    for (int i = 1; i < arr.length; i++) {
      int temp = arr[i];
      int j = i;
      for (; j > 0 && temp < arr[j - 1]; j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = temp;
    }
  }

  /**
   * 插入排序
   * 希尔排序：使用缩减增量排序，使排序的数相对有序
   *
   * @param arr
   */
  public static void shellSor(int arr[]) {
    for (int p = arr.length / 2; p > 0; p /= 2) {
      for (int i = p; i < arr.length; i++) {
        int temp = arr[i];

        int j = i;

        for (; j >= p && temp < arr[j - p]; j = j - p) {
          arr[j] = arr[j - p];
        }
        arr[j] = temp;
      }
    }
  }

  /**
   * 插入排序
   * 折半插入排序，使用折半查找法定位需要插入的位置
   *
   * @param arr
   */
  public static void binInsertSort(int arr[]) {

    for (int i = 1; i < arr.length; i++) {

      int temp = arr[i];

      int start = 0;
      int end = i - 1;

      while (start <= end) {
        int p = (start + end) / 2;
        if (temp < arr[p]) {
          end = p - 1;
        } else {
          start = p + 1;
        }
      }
      int j = i;
      for (; j > end + 1; j--) {
        arr[j] = arr[j - 1];
      }

      arr[end + 1] = temp;
    }
  }
//======================================================================================================================

  /**
   * 归并算法
   * 对两个已经排序的数列进行排序
   *
   * @param arr1
   * @param arr2
   * @return
   */
  public static int[] merge(int arr1[], int arr2[]) {

    int p = 0;
    int arr[] = new int[arr1.length + arr2.length];

    int j = 0;
    for (int i = 0; i < arr1.length; i++) {
      int temp = arr1[i];
      while (j < arr2.length && temp > arr2[j]) {
        arr[p++] = arr2[j++];
      }
      arr[p++] = temp;
    }
    for (; j < arr2.length; ) {
      arr[p++] = arr[j++];
    }
    return arr;
  }

  /**
   * 归并算法
   * 结合使用插入算法
   *
   * @param arr
   * @param s
   * @param m
   * @param e
   */
  public static void merge2(int arr[], int s, int m, int e) {
    int p = m + 1;

    for (int i = s; i <= m; i++) {
      int temp = arr[i];
      if (p <= e && temp <= arr[p]) {
        continue;
      } else {
        int temp2 = arr[p];
        for (int j = p; j > i; j--) {
          arr[j] = arr[j - 1];
        }
        p++;
        m++;
        arr[i] = temp2;
      }
    }
  }

  /**
   * 归并算法
   * 使用额外空间
   *
   * @param a
   * @param p
   * @param q
   * @param r
   */
  private static void merge(int[] a, int p, int q, int r) {
    int[] b = new int[r - p + 1];
    int s = p;
    int t = q + 1;
    int k = 0;
    while (s <= q && t <= r) {
      if (a[s] < a[t]) {
        b[k++] = a[s++];
      } else {
        b[k++] = a[t++];
      }
    }

    while (s <= q) {
      b[k++] = a[s++];
    }
    while (t <= r) {
      b[k++] = a[t++];
    }
    for (int i = 0; i < b.length; i++)
      a[p + i] = b[i];
  }

  /**
   * 递归实现归并排序
   *
   * @param arr
   * @param low
   * @param high
   */
  public static void mergeSort(int arr[], int low, int high) {
    if (low < high) {
      mergeSort(arr, low, (high + low) / 2);
      mergeSort(arr, (high + low) / 2 + 1, high);
      merge(arr, low, (high + low) / 2, high);
    }
  }

//======================================================================================================================

  /**
   * 选择排序
   * 简单选择排序
   *
   * @param arr
   */
  public static void simpleSelectSort(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      int p = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[p] > arr[j]) {
          p = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[p];
      arr[p] = temp;
    }
  }

  /**
   * 大堆调整(前提是其子树都已经是大堆)
   *
   * @param arr
   * @param position
   * @param length
   */
  public static void heapAdjust(int arr[], int position, int length) {

    int temp = arr[position];
    // 节点发生上滤操作后需要对其子树进行上滤操作
    // i 下一个需要上滤的堆顶位置
    for (int i = position * 2 + 1; i < length; i = position * 2 + 1) {
      int max;
      if ((i + 1) < length) {
        max = arr[i] > arr[i + 1] ? i : i + 1;
      } else {
        max = i;
      }

      if (temp > arr[max]) {
        break;
      } else {
        arr[position] = arr[max];
        position = max;
      }
    }
    arr[position] = temp;

  }

  public static void buildHeap(int arr[]) {
    int n = arr.length;
    for (int position = arr.length / 2 - 1; position >= 0; position--) {
      heapAdjust(arr, position, n);
    }
  }

  public static void heapSort(int arr[]) {
    buildHeap(arr);

    for (int i = arr.length; i > 1; i--) {
      int temp = arr[0];
      arr[0] = arr[i - 1];
      arr[i - 1] = temp;
      heapAdjust(arr, 0, i - 1);
    }
  }

}
