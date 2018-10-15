package daiyun.tree;

public class BinTree<AnyType extends Comparable<? super AnyType>> {
  public AnyType value;
  public BinTree<AnyType> left;
  public BinTree<AnyType> right;
  public int height;

  public BinTree() {
    this(null, null, null);
  }

  public BinTree(AnyType value) {
    this(value, null, null);
  }

  public BinTree(AnyType value, BinTree left, BinTree right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}
