package daiyun.leetcode;


/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * <p>
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 */
public class Topic116 {

    public static void main(String[] args) {

        Topic116 topic1 = new Topic116();

        Solution solution = topic1.new Solution();

        long start = System.currentTimeMillis();


        System.out.println(System.currentTimeMillis() - start);
    }


    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        public Node connect(Node root) {
            /*if (root == null) {
                return root;
            }
            List<Node> nodes = new ArrayList<>();
            nodes.add(root);

            while (nodes.size() > 0) {
                List<Node> nextLevelNodes = new ArrayList<>();
                for (int i = 0; i < nodes.size(); i++) {
                    Node cur = nodes.get(i);
                    if (i < nodes.size() - 1) {
                        cur.next = nodes.get(i + 1);
                    }
                    if (cur.left != null) {
                        nextLevelNodes.add(cur.left);
                        nextLevelNodes.add(cur.right);
                    }
                }
                nodes = nextLevelNodes;
            }

            return root;*/

            return treeB(root, null);
        }

        public Node treeB(Node node, Node preNode) {

            if (node == null) {
                return null;
            }

            node.next = preNode;

            node.left = treeB(node.left, node.right);

            if (node.next != null) {
                node.right = treeB(node.right, node.next.left);
            } else {
                node.right = treeB(node.right, null);
            }

            return node;
        }
    }
}
