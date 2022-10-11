package daiyun.sort;

public class SortTools {

    public static void main(String[] args) {

        int arr4[] = {2, 3, 24, 48, 56, 1, 2, 4, 7, 12, 59};
        sampleInsert(arr4);

        printArr(arr4);
        System.out.println();

        int arr1[] = {1, 6, 5, 67, 4, 345, 3456, 2, 34534};
        mergeSort(arr1, 0, arr1.length - 1);
        printArr(arr1);
    }


    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    /**
     * 交换排序-冒泡排序
     */
    public static void sampleExchange(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int p = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = p;
                }
            }
        }
    }

    /**
     * 选择排序-简单选择排序
     */
    public static void sampleSelect(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int p = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[p] > arr[j]) {
                    p = j;
                }
            }

            int tem = arr[i];
            arr[i] = arr[p];
            arr[p] = tem;
        }
    }

    /**
     * 插入排序-简单插入排序
     */
    public static void sampleInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    /**
     * 插入排序-择半插入
     *
     * @param arr
     */
    public static void binInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int s = 0;
            int e = i - 1;

            while (s <= e) {
                int l = (s + e) / 2;
                if (arr[l] > arr[i]) {
                    e = l - 1;
                } else {
                    s = l + 1;
                }
            }

            int tmp = arr[i];
            for (int j = i; j > e && j > 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[e + 1] = tmp;
        }
    }

    /**
     * 插入排序-希尔排序
     */
    public static void shellInsert(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {

            for (int i = gap; i < arr.length; i++) {

                int tmp = arr[i];

                int j = i;
                for (; j >= gap && tmp < arr[j - gap]; j = j - gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = tmp;
            }
        }
    }


    /**
     * 归并排序
     */
    private static void mergeSort(int[] arr, int s, int e) {

        if (s >= e) {
            return;
        }

        int l = s + e;
        mergeSort(arr, s, l / 2);
        mergeSort(arr, l / 2 + 1, e);

        merge(arr, 0, l / 2, e);
    }


    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int p = 0;

        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.length || bIndex < b.length) {
            boolean aFlag = false;
            if (aIndex < a.length && bIndex < b.length) {
                if (a[aIndex] < b[bIndex]) {
                    aFlag = true;
                }
            } else if (aIndex < a.length) {
                aFlag = true;
            }

            if (aFlag) {
                res[p++] = a[aIndex++];
            } else {
                res[p++] = b[bIndex++];
            }
        }

        return res;
    }


    public static void merge(int[] a, int s, int m, int l) {

        for (int i = m + 1; i <= l; i++) {

            int tmp = a[i];
            int p = i;
            for (; p > s && tmp < a[p - 1]; p--) {
                a[p] = a[p - 1];
            }
            a[p] = tmp;
        }
    }
}
