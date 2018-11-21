package daiyun.sort;

public class SortUtil {

  public static void main(String[] args) {

    int[] arr = {1, 4, 5, 67, 1, 2, 5, 8, 9};
    heapSort(arr);

    printArr(arr);

  }

  public static void printArr(int[] arr) {
    for (int i : arr) {
      System.out.print(i + ", ");
    }
  }

  //=======================================================交换排序

  /**
   * 冒泡排序
   *
   * @param arr
   */
  public static void sampleExchangeSort(int[] arr) {
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
   * 快速排序
   *
   * @param arr
   * @param start
   * @param end
   */
  public static void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int mid = onceQuickSort(arr, start, end);
      quickSort(arr, start, mid - 1);
      quickSort(arr, mid + 1, end);
    }
  }

  private static int onceQuickSort(int[] arr, int start, int end) {
    int temp = arr[start];
    while (start < end) {
      while (start < end && arr[end] >= temp) {
        end--;
      }
      if (start < end) {
        arr[start++] = arr[end];
      }
      while (start < end && arr[start] <= temp) {
        start++;
      }
      if (start < end) {
        arr[end--] = arr[start];
      }
    }
    arr[start] = temp;
    return start;
  }

  //=================================================插入排序

  /**
   * 简单插入排序
   *
   * @param arr
   */
  public static void sampleInsertSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int temp = arr[i];
      int j = i;
      for (; j > 0 && arr[j - 1] > temp; j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = temp;
    }
  }

  /**
   * 折半插入排序
   *
   * @param arr
   */
  public static void binInsertSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {

      int temp = arr[i];
      int start = 0;
      int end = i - 1;
      while (start <= end) {
        if (temp > arr[(start + end) / 2]) {
          start = (start + end) / 2 + 1;
        } else {
          end = (start + end) / 2 - 1;
        }
      }
      for (int j = i; j > end + 1; j--) {
        arr[j] = arr[j - 1];
      }
      arr[end + 1] = temp;
    }
  }

  /**
   * 希尔排序
   *
   * @param arr
   */
  public static void sellSort(int[] arr) {
    for (int p = arr.length / 2; p > 0; p = p / 2) {

      for (int i = p; i < arr.length; i++) {
        int temp = arr[i];
        int j = i;

        for (; j >= p && arr[j - p] > temp; j = j - p) {
          arr[j] = arr[j - p];
        }
        arr[j] = temp;
      }

    }
  }

  //===========================================归并排序
  public static void mergeSort(int[] arr, int start, int end) {
    if (start < end) {
      mergeSort(arr, start, (start + end) / 2);
      mergeSort(arr, (start + end) / 2 + 1, end);
      merge(arr, start, (start + end) / 2, end);
    }
  }

  /**
   * 利用插入排序实现归并
   *
   * @param arr
   * @param start
   * @param k
   * @param end
   */
  private static void merge(int[] arr, int start, int k, int end) {
    for (int i = k + 1; i <= end; i++) {
      int temp = arr[i];
      int j = i;
      for (; j > start && arr[j - 1] > temp; j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = temp;
    }
  }

  //=====================================================选择排序
  public static void sampleSelectSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int p = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[p]) {
          p = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[p];
      arr[p] = temp;
    }
  }

  /**
   * 堆排序
   *
   * @param arr
   */
  public static void heapSort(int[] arr) {
    heapBuild(arr);

    for (int i = arr.length; i > 0; i--) {

      int temp = arr[0];
      arr[0] = arr[i - 1];
      arr[i - 1] = temp;
      precolcateDown(arr, 0, i - 1);
    }
  }

  public static void heapBuild(int[] arr) {
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
      precolcateDown(arr, i, arr.length);
    }
  }

  public static void precolcateDown(int[] arr, int i, int length) {

    int node = arr[i];
    int j = i;
    for (; j < length; ) {
      if (2 * j + 2 < length) {
        int p = arr[2 * j + 1] > arr[2 * j + 2] ? 2 * j + 1 : 2 * j + 2;
        if (node > arr[p]) {
          break;
        } else {
          arr[j] = arr[p];
          j = p;
        }
      } else if (2 * j + 1 < length) {
        if (arr[j] > arr[2 * j + 1]) {
          break;
        } else {
          arr[j] = arr[2 * j + 1];
          j = 2 * j + 1;
        }
      } else {
        break;
      }
    }
    arr[j] = node;
  }


}
