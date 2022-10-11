package daiyun.leetcode.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Offer11 {

    public static void main(String[] args) {


    }

    class Solution {
        public int minArray(int[] numbers) {
            if (numbers == null || numbers.length < 1) {
                return 0;
            }

            int leftP = 0;
            int rightP = numbers.length - 1;

            while (leftP <= rightP) {
                int mid = (leftP + rightP) / 2;

                if (numbers[leftP] == numbers[rightP]) {
                    leftP++;
                } else if (numbers[leftP] > numbers[rightP] && numbers[leftP] <= numbers[mid]) {
                    leftP = mid + 1;
                } else {
                    rightP = mid;
                }
            }

            return numbers[leftP];
        }
    }

}
