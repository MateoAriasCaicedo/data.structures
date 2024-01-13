package mateo.arias.data.structures;

public class DoubleLinkedList<T> {

  private Node<T> head;

  private Node<T> tail;

  private int size;

  public DoubleLinkedList() {
    size = 0;
  }

  public void addLast(T element) {
    Node<T> node = createNode(element);

    if (head == null) {
      head = node;
    } else {
      tail.setNext(node);
      node.setPrevious(tail);
    }

    tail = node;
    size++;
  }

  public void addFirst(T element) {
    Node<T> node = createNode(element);

    if (head == null) {
      tail = node;
    } else {
      node.setNext(head);
      head.setPrevious(node);
    }

    head = node;
    size++;
  }

  public T get(int index) {
    if (indexIsOutOfBounds(index)) throw new IndexOutOfBoundsException();

    Node<T> node = findNode(index, startByHead(index));

    return node.getElement();
  }

  private Node<T> findNode(int index, boolean startByHead) {
    Node<T> node;

    if (startByHead) {
      node = head;

      for (int i = 0; i < index; i++) {
        node = node.getNext();
      }
    } else {
      node = tail;

      for (int i = size - 1; i > index; i--) {
        node = node.getPrevious();
      }
    }

    return node;
  }

  public void removeFirst() {
    if (head == null) throw new IllegalStateException();

    if (size == 1) {
      clean();
    } else {
      Node<T> newHead = head.getNext();
      newHead.setPrevious(null);
      head = newHead;
    }

    size--;
  }

  public void setFirst(T element) {
    if (size == 0) throw new IllegalStateException();

    if (size == 1) {
      tail.setElement(element);
    }

    head.setElement(element);
  }

  public void setLast(T element) {
    if (size == 0) throw new IllegalStateException();

    if (size == 1) {
      head.setElement(element);
    }

    tail.setElement(element);
  }

  public void set(T element, int index) {
    if (size == 0) throw new IllegalStateException();

    if (size == 1) {
      head.setElement(element);
      tail.setElement(element);
    } else {
      if (indexIsOutOfBounds(index)) throw new IndexOutOfBoundsException();
      Node<T> node = findNode(index, startByHead(index));
      node.setElement(element);
    }
  }

  public void removeLast() {
    if (head == null) throw new IllegalStateException();

    if (size == 1) {
      clean();
    } else {
      Node<T> newTail = tail.getPrevious();
      newTail.setNext(null);
      tail = newTail;
    }

    size--;
  }

  public T getFirst() {
    if (size == 0) throw new IllegalStateException();
    return head.getElement();
  }

  public T getLast() {
    if (size == 0) throw new IllegalStateException();
    return tail.getElement();
  }

  public void clean() {
    head = null;
    tail = null;
    size = 0;
  }

  private boolean indexIsOutOfBounds(int index) {
    return index >= size || index < 0;
  }

  private boolean startByHead(int index) {
    return index <= (size / 2);
  }

  public int size() {
    return size;
  }

  private Node<T> createNode(T element) {
    return new Node<>(element);
  }

  private static class Node<T> {

    private T element;

    private Node<T> previous;

    private Node<T> next;

    public Node(T element) {
      this.element = element;
    }

    public T getElement() {
      return element;
    }

    public void setElement(T element) {
      this.element = element;
    }

    public Node<T> getPrevious() {
      return previous;
    }

    public void setPrevious(Node<T> previous) {
      this.previous = previous;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }
  }
}
