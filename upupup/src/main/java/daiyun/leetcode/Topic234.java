package daiyun.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 */
public class Topic234 {

    public static void main(String[] args) {

        Topic234 topic1 = new Topic234();

        Solution solution = topic1.new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node4.next = node3;
        node3.next = node2;
        node2.next= node1;

        System.out.println(solution.isPalindrome(node4));


    }

    static public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null){
                return false;
            }

            ListNode p1 = head;
            ListNode p2 = head.next;
            while(p2 != null && p2.next!=null){
                p1 = p1.next;
                p2 = p2.next.next;
            }

            ListNode p4 = p1.next;
            ListNode p3 = null;
            while(p4 != null){
                ListNode temp = p4.next;
                p4.next = p3;
                p3 = p4;
                p4 = temp;
            }

            boolean res = true;
            p4 = head;
            ListNode k = p3;
            while(p4 !=null && k !=null){
                if(p4.val != k.val){
                    res = false;
                    break;
                }
                p4 = p4.next;
                k = k.next;
            }

            p4 = null;
            while(p3 != null){
                ListNode temp = p3.next;
                p3.next = p4;
                p4 = p3;

                p3 = temp;
            }

            p1.next = p4;

            return res;
        }
    }

}
