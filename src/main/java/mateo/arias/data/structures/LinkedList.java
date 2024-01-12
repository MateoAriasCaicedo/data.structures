package mateo.arias.data.structures;

public class LinkedList<T> {

  private Node<T> first;

  public void add(T value) {
    if (first == null) {
      first = new Node<>(value);
    } else {
      Node<T> lastNode = findLastNode();
      lastNode.next = new Node<>(value);
    }
  }

  private Node<T> findLastNode() {
    Node<T> current = first;

    while (current.next != null) {
      current = current.next;
    }

    return current;
  }

  public T get(int index) throws IndexOutOfBoundsException {
    if (index < 0) throw new IndexOutOfBoundsException();

    Node<T> indexNode = findNodeAtIndex(index);
    return indexNode.getValue();
  }

  private Node<T> findNodeAtIndex(int index) throws IndexOutOfBoundsException {
    Node<T> current = first;

    for (int i = 0; i < index; i++) {
      if (current == null) throw new IndexOutOfBoundsException();
      current = current.next;
    }

    return current;
  }

  public void set(int index, T value) throws IndexOutOfBoundsException {
    if (index < 0) throw new IndexOutOfBoundsException();

    Node<T> indexNode = findNodeAtIndex(index);
    indexNode.setValue(value);
  }

  public void remove(int index) {
    if (index < 0) throw new IndexOutOfBoundsException();

    if (index == 0) {
      first = first.next;
    } else {
      Node<T> beforeIndexNode = findNodeAtIndex(index - 1);
      try {
        beforeIndexNode.next = beforeIndexNode.next.next;
      } catch (NullPointerException exception) {
        throw new IndexOutOfBoundsException();
      }
    }
  }

  public void insert(int index, T value) {
    if (index < 0) throw new IndexOutOfBoundsException();

    Node<T> newNode = new Node<>(value);
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      Node<T> beforeIndexNode = findNodeAtIndex(index - 1);
      try {
        newNode.next = beforeIndexNode.next;
      } catch (NullPointerException exception) {
        throw new IndexOutOfBoundsException();
      }
      beforeIndexNode.next = newNode;
    }
  }

  private static class Node<T> {

    private T value;

    private Node<T> next;

    public Node(T value) {
      this.value = value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    public T getValue() {
      return value;
    }
  }
}
