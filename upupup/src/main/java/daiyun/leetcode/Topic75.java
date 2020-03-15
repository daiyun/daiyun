package daiyun.leetcode;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Topic75 {

    public static void main(String[] args) {

        Topic75 topic1 = new Topic75();

        SolutionA solution = topic1.new SolutionA();


        solution.sortColors(new int[]{2, 2, 2, 1, 1, 1});

        System.out.println();
    }


    class Solution {
        public void sortColors(int[] nums) {

            if (nums == null || nums.length <= 1) {
                return;
            }

            int len = nums.length;

            for (int i = 0; i < len; i++) {
                int p = i;
                for (int j = i; j < len; j++) {
                    if (nums[p] > nums[j]) {
                        p = j;
                    }
                }

                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
            }
        }
    }

    class SolutionA {
        public void sortColors(int[] nums) {

            if (nums == null || nums.length <= 1) {
                return;
            }

            int len = nums.length;
            int[] count = new int[3];

            for (int i = 0; i < len; i++) {
                count[nums[i]]++;
            }

            int index = 0;
            for (int i = 0; i < count[0]; i++) {
                nums[index] = 0;
                index++;
            }

            for (int i = 0; i < count[1]; i++) {
                nums[index] = 1;
                index++;
            }

            for (int i = 0; i < count[2]; i++) {
                nums[index] = 2;
                index++;
            }
            System.out.println();
        }
    }


}
