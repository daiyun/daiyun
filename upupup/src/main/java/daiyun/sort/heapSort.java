package daiyun.sort;

/**
 * @author godai
 * @date 2021/7/31 16:28
 * @description
 */
public class heapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,45,2,3,12,24,-1};

        sort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }


    public static void sort(int[] arr) {
        buildHeap(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            adjustHead(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHead(arr, i, arr.length);
        }
    }

    private static void adjustHead(int[] arr, int i, int limit) {
        int p = i;
        while (p < limit) {
            int tmp = p;

            if (p * 2 + 1 < limit && arr[p * 2 + 1] > arr[tmp]) {
                tmp = p * 2 + 1;
            }

            if (p * 2 + 2 < limit && arr[p * 2 + 2] > arr[tmp]) {
                tmp = p * 2 + 2;
            }

            if (tmp == p) {
                break;
            }
            int k = arr[p];
            arr[p] = arr[tmp];
            arr[tmp] = k;

            p = tmp;
        }
    }
}
