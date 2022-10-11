package daiyun.leetcode;


import scala.Int;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic207 {

    public static void main(String[] args) {

        Topic207 topic1 = new Topic207();

        Solution solution = topic1.new Solution();

        solution.canFinish(2, new int[][]{{0, 1}, {1, 0}});

//        solution.numIslands(new char[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}});
    }


    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null || prerequisites.length == 0) {
                return true;
            }

            HashMap<Integer, Set<Integer>> grap = new HashMap<>();

            for (int[] require : prerequisites) {
                if (!grap.containsKey(require[0])) {
                    grap.put(require[0], new HashSet<>());
                }
                grap.get(require[0]).add(require[1]);
            }

            for (int i = 0; i < numCourses; i++) {
                Set<Integer> tra = new HashSet<>(i);
                if (isCycle(i, grap, tra)) {
                    return false;
                }
            }

            return true;
        }

        public boolean isCycle(int numCourses, HashMap<Integer, Set<Integer>> grap, Set<Integer> tra) {
            Set<Integer> allLimit = grap.get(numCourses);
            if (allLimit == null || allLimit.size() == 0) {
                return false;
            }

            for (Integer a : allLimit) {
                if (tra.contains(a)) {
                    return true;
                } else {
                    tra.add(a);
                    if (isCycle(a, grap, tra)) {
                        return true;
                    }
                    tra.remove(a);
                }
            }

            return false;
        }
    }
}
