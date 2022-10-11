package daiyun.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
public class Topic2 {

    public static void main(String[] args) {

        Topic2 topic1 = new Topic2();

        SolutionB solution = topic1.new SolutionB();


        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(1);

        ListNode l2 = new ListNode(1);

        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println();
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            ListNode pNode = res;

            int p = 0;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    int a = l1.val;
                    int b = l2.val;
                    int c = a + b + p;
                    if (c > 9) {
                        pNode.next = new ListNode(c % 10);
                        p = c / 10;
                    } else {
                        pNode.next = new ListNode(c);
                        p = 0;
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                } else if (l1 != null) {
                    int c = p + l1.val;
                    if (c > 9) {
                        pNode.next = new ListNode(c % 10);
                        p = c / 10;
                    } else {
                        pNode.next = new ListNode(c);
                        p = 0;
                    }
                    l1 = l1.next;
                } else if (l2 != null) {
                    int c = p + l2.val;
                    if (c > 9) {
                        pNode.next = new ListNode(c % 10);
                        p = c / 10;
                    } else {
                        pNode.next = new ListNode(c);
                        p = 0;
                    }
                    l2 = l2.next;
                }
            }
            return res.next;
        }
    }

    class SolutionA {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            ListNode res = new ListNode(0);
            ListNode nodeP = res;
            int p = 0;
            while (l1 != null || l2 != null) {
                int a = 0;
                if (l1 != null) {
                    a = l1.val;
                    l1 = l1.next;
                }

                int b = 0;
                if (l2 != null) {
                    b = l2.val;
                    l2 = l2.next;
                }

                int addRes = a + b + p;
                p = 0;
                if (addRes >= 10) {
                    p = 1;
                    addRes = addRes - 10;
                }

                nodeP.next = new ListNode(addRes);
                nodeP = nodeP.next;
            }
            if (p > 0) {
                nodeP.next = new ListNode(p);
            }


            return res.next;
        }
    }

    class SolutionB {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 边界值判断
            if(l2 == null){
                return l1;
            }
            if(l1 == null){
                return l2;
            }

            // 用于记录返回头节点
            ListNode root = new ListNode();
            ListNode p = root;
            int temp = 0;
            while(l1 != null || l2 != null){
                if(l1 != null && l2 != null){
                    int pVal = l1.val + l2.val + temp;
                    temp = pVal / 10;
                    p.next = new ListNode(pVal%10);
                    p = p.next;
                    l1 = l1.next;
                    l2 = l2.next;
                }else if(l1 != null){
                    if(temp > 0){
                        int pVal = l1.val+temp;
                        temp = pVal / 10;
                        p.next = new ListNode(pVal%10);
                        l1 = l1.next;
                        p = p.next;
                    }else{
                        p.next = l1;
                        break;
                    }
                }else if(l2 != null){
                    if(temp > 0){
                        int pVal = l2.val+temp;
                        temp = pVal / 10;
                        p.next = new ListNode(pVal%10);
                        l2 = l2.next;
                        p = p.next;
                    }else{
                        p.next = l2;
                        break;
                    }
                }
            }
            if(temp > 0){
                p.next = new ListNode(temp);
            }

            return root.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(){}

        ListNode(int x) {
            val = x;
        }
    }
}
