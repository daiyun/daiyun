package daiyun.leetcode.lcci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * 给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * 给定如下二叉树
 * <p>
 * 2
 * / \
 * 1   3
 * 返回：
 * <p>
 * [
 * [2,1,3],
 * [2,3,1]
 * ]
 */
public class Question0409 {

    public static void main(String[] args) {
        Question0409 question = new Question0409();

        Question0409.Solution solution = question.new Solution();


        TreeNode root12 = new TreeNode(12);
        TreeNode root9 = new TreeNode(9);
        TreeNode root3 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);


        TreeNode root4 = new TreeNode(4);
        root4.left = root2;
        root4.right = root3;

        TreeNode root11 = new TreeNode(11);
        root11.left = root9;
        root11.right = root12;

        TreeNode root = new TreeNode(8);
        root.left = root4;
        root.right = root11;

        List<List<Integer>> res = solution.BSTSequences(root);

        System.out.println();

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> BSTSequences(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                res.add(new ArrayList<>());
                return res;
            }

            List<List<Integer>> left = BSTSequences(root.left);

            List<List<Integer>> right = BSTSequences(root.right);

            res = listMix(left, right);
            for (List<Integer> list : res) {
                list.add(0, root.val);
            }
            if (res == null || res.size() == 0) {
                List<Integer> basicOne = new ArrayList<>();
                basicOne.add(root.val);
                res.add(basicOne);
            }

            return res;
        }

        public List<List<Integer>> listMix(List<List<Integer>> left, List<List<Integer>> right) {
            List<List<Integer>> res = new ArrayList<>();

            if (left == null || left.size() == 0) {
                return right;
            }


            if (right == null || right.size() == 0) {
                return left;
            }

            for (List<Integer> leftList : left) {
                for (List<Integer> rightList : right) {
                    res.addAll(doListMix(leftList, rightList));
                }
            }

            return res;
        }

        public List<List<Integer>> doListMix(List<Integer> left, List<Integer> right) {
            List<List<Integer>> res = new ArrayList<>();
            if (left == null || left.size() == 0) {
                res.add(right);
                return res;
            }

            if (right == null || right.size() == 0) {
                res.add(left);
                return res;
            }

            Integer leftFirst = left.get(0);
            Integer rightFirst = right.get(0);

            List<Integer> leftRemove = new ArrayList<>(left);
            leftRemove.remove(0);

            List<Integer> rightRemove = new ArrayList<>(right);
            rightRemove.remove(0);

            List<List<Integer>> resLeft = doListMix(leftRemove, right);
            for (List<Integer> list : resLeft) {
                List<Integer> addList = new ArrayList<>(list);
                addList.add(0, leftFirst);
                res.add(addList);
            }

            List<List<Integer>> resRight = doListMix(left, rightRemove);
            for (List<Integer> list : resRight) {
                List<Integer> addList = new ArrayList<>(list);
                addList.add(0, rightFirst);
                res.add(addList);
            }

            return res;
        }


    }

    class SolutionA {
        public List<List<Integer>> BSTSequences(TreeNode root) {
            if (root == null) {
                return null;
            }

            List<List<Integer>> res = new ArrayList<>();
            List<TreeNode> levelNode = new ArrayList<>();
            levelNode.add(root);

            while (levelNode.size() > 0) {
                List<TreeNode> nextLevel = new ArrayList<>();

                for (TreeNode node : levelNode) {
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }

                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                }

                if (res.size() == 0) {
                    res.addAll(doBSTSequences(levelNode));
                } else {
                    List<LinkedList<Integer>> nextIndex = doBSTSequences(levelNode);

                    List<List<Integer>> newRes = new ArrayList<>();

                    for (List<Integer> temp : res) {
                        for (List<Integer> nextTemp : nextIndex) {
                            List<Integer> p = new ArrayList<>(temp);
                            p.addAll(nextTemp);
                            newRes.add(p);
                        }
                    }

                    res = newRes;
                }

                levelNode = nextLevel;
            }

            return res;
        }

        public List<LinkedList<Integer>> doBSTSequences(List<TreeNode> root) {
            List<LinkedList<Integer>> res = new ArrayList<>();
            if (root.size() == 1) {

                LinkedList<Integer> p = new LinkedList<>();
                p.add(root.get(0).val);
                res.add(p);
                return res;
            }

            TreeNode node = root.remove(0);

            res = doBSTSequences(root);

            List<LinkedList<Integer>> newRes = new ArrayList<>();
            for (LinkedList<Integer> list : res) {
                for (int i = 0; i < list.size() + 1; i++) {
                    LinkedList<Integer> temp = new LinkedList<>(list);
                    temp.add(i, node.val);
                    newRes.add(temp);
                }
            }

            return newRes;
        }
    }

}
