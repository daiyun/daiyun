package daiyun.leetcode.lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * 示例2:
 * <p>
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * 提示：
 * <p>
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 */
public class Question0401 {

    public static void main(String[] args) {
        Question0401 question = new Question0401();

        Question0401.Solution solution = question.new Solution();

        boolean res = solution.findWhetherExistsPath(5,
                new int[][]{{0, 1}, {1, 2}, {2, 1}, {2, 3}, {3, 2}, {3, 4}},
                0, 4);

        System.out.println(res);

    }


    class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            if (n < 1 || graph == null || graph.length < 1) {
                return false;
            }

            Set<Integer>[] graphSe = new Set[n];
            for (int i = 0; i < graph.length; i++) {
                int[] way = graph[i];
                if (graphSe[way[0]] == null) {
                    graphSe[way[0]] = new HashSet<>();
                }
                if (way[1] != way[0]) {
                    graphSe[way[0]].add(way[1]);
                }
            }
            Set<Integer> track = new HashSet<>();
            track.add(start);
            return skipTrue(graphSe, track, start, target);
        }

        public boolean skipTrue(Set<Integer>[] graphSe, Set<Integer> track, int start, int target) {

            if (graphSe[start] == null) {
                return false;
            }

            if (graphSe[start].contains(target)) {
                track.add(target);
                return true;
            }

            for (Integer trackNode : graphSe[start]) {
                if (track.contains(trackNode)) {
                    continue;
                }
                track.add(trackNode);
                if (skipTrue(graphSe, track, trackNode, target)) {
                    return true;
                } else {
                    track.remove(trackNode);
                }
            }

            return false;
        }
    }

}
