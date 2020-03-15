package daiyun.leetcode;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Topic31 {

    public static void main(String[] args) {

        Topic31 topic1 = new Topic31();

        Solution solution = topic1.new Solution();

        solution.nextPermutation(new int[]{3, 2, 1});
    }

    class Solution {
        public void nextPermutation(int[] nums) {

            if (nums == null || nums.length == 1) {
                return;
            }

            int len = nums.length;


            int pre = 0;
            for (int i = len - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {

                    int j = i + 1;
                    while (j < len - 1 && nums[j + 1] > nums[i]) {
                        j++;
                    }
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    pre = j;
                    break;
                }
            }

            int end = len - 1;
            while (pre < end) {
                int temp = nums[pre];
                nums[pre] = nums[end];
                nums[end] = temp;
                end--;
                pre++;
            }
            System.out.println();
        }
    }
}
