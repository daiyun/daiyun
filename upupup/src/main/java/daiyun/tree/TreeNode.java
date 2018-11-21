package daiyun.tree;

public class TreeNode<T> {

  public TreeNode left;
  public TreeNode right;
  public int height;
  public T element;

  public TreeNode(T element) {
    this.element = element;
  }

  public TreeNode(TreeNode left, TreeNode right, int height, T element) {
    this.left = left;
    this.right = right;
    this.height = height;
    this.element = element;
  }
}
