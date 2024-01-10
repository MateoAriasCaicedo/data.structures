package mateo.arias.data.structures;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

  private Node root;

  public BinarySearchTree() {}

  public BinarySearchTree(int value) {
    this.root = new Node(value);
  }

  public List<Integer> toList() {
    return toList(new ArrayList<>(), root);
  }

  public boolean contains(int value) {
    return contains(root, value);
  }

  private static boolean contains(Node current, int value) {
    boolean contains;

    if (current == null) {
      contains = false;
    } else if (value == current.value) {
      contains = true;
    } else if (value < current.value) {
      contains = contains(current.left, value);
    } else {
      contains = contains(current.right, value);
    }

    return contains;
  }

  public void add(int value) {
    this.root = add(root, value);
  }

  private static Node add(Node current, int value) {

    if (current == null) {
      return new Node(value);
    } else if (value < current.value) {
      current.left = add(current.left, value);
    } else if (value > current.value) {
      current.right = add(current.right, value);
    }

    return current;
  }

  private static List<Integer> toList(List<Integer> list, Node current) {
    if (current == null) return list;

    toList(list, current.left);
    list.add(current.value);
    toList(list, current.right);

    return list;
  }

  private static class Node {

    private int value;

    private Node left, right;

    public Node() {}

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }
  }
}
