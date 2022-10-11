package daiyun.tree;

import java.util.Arrays;
import java.util.List;

public class HeapOptions<AnyType extends Comparable<? super AnyType>> {

    public static void main(String[] args) {

    }

    int currentSize = 0;

    AnyType[] arr;

    public HeapOptions(AnyType[] arr) {
        this.arr = arr;
    }

    public void enlargeArr(int size) {


    }

    public AnyType findMin() {
        return arr[1];
    }

    public void add(AnyType node) {
        if (currentSize == arr.length - 1) {
            enlargeArr(arr.length * 2 + 1);
        }

        arr[currentSize++] = node;

        preOrder(currentSize - 1);
    }


    public void preOrder(int index) {
        int p = index / 2;
        if (arr[p].compareTo(arr[index]) > 0) {
            arr[0] = arr[p];
            arr[p] = arr[index];
            arr[index] = arr[0];
            preOrder(p);
        }
    }


    public void deleteMin() {
        arr[1] = arr[currentSize--];

        nextOder(1);
    }

    private void nextOder(int i) {
        AnyType tmp = arr[i];

        int child;

        for (; i * 2 <= currentSize; i = child) {
            child = i * 2;

            if (child < currentSize && arr[child + 1].compareTo(arr[child]) < 0) {
                child++;
            }

            if (arr[i].compareTo(arr[child]) > 0) {
                arr[i] = arr[child];
            } else {
                break;
            }
        }

        arr[i] = tmp;
    }

    public static List<Node> insert(List<Node> root, Node node) {
        if (root == null) {
            return Arrays.asList(node);
        }

        root.add(node);

        return upCheck(root, root.size() - 1);
    }

    public static List<Node> upCheck(List<Node> root, int index) {
        if (root == null || root.size() >= index) {
            return root;
        }

        int pIndex = 0;
        if (index % 2 == 0) {
            pIndex = index / 2 - 1;
        } else {
            pIndex = (index - 1) / 2;
        }
        if (pIndex < 0) {
            return root;
        }

        Node p = root.get(pIndex);

        Node pLeft = p.left;
        Node pRight = p.right;

        Node min = null;
        if (pLeft != null && pRight != null) {
            if (pLeft.value.compareTo(pRight.value) > 0) {
                min = pRight;
            } else {
                min = pLeft;
            }
        } else if (pLeft != null) {
            min = pLeft;
        } else if (pRight != null) {
            min = pRight;
        }

        if (p.value.compareTo(min.value) > 0) {
            Node k = p;
            p.value = min.value;
            min.value = k.value;
            return upCheck(root, pIndex);
        } else {
            return root;
        }
    }

    public static Node delete(Node root) {
        if (root == null) {
            return null;
        }

        Node left = root.left;
        Node right = root.right;

        boolean leftFlag = false;
        if (left != null && right != null && left.value.compareTo(right.value) < 0) {
            if (left.value.compareTo(right.value) < 0) {
                leftFlag = true;
            }
        } else if (left != null) {
            leftFlag = true;
        } else if (right != null) {
        } else {
            return null;
        }

        if (leftFlag) {
            root.value = left.value;
            root.left = delete(root.left);
        } else {
            root.value = right.value;
            root.right = delete(root.right);
        }

        return root;
    }


    static class Node<T extends Comparable> {
        Node<T> left;
        Node<T> right;

        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
