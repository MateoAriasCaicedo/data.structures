package mateo.arias.data.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoubleLinkedListTest {

  DoubleLinkedList<Integer> list;

  @BeforeEach
  void setup() {
    list = new DoubleLinkedList<>();
    list.addFirst(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    list.addLast(6);
    list.addLast(7);
    list.addLast(8);
    list.addLast(9);
    list.addLast(10);
  }

  @Test
  void addLast() {
    list.addLast(11);
    assertEquals(11, list.getLast());
  }

  @Test
  void addFirst() {
    list.addFirst(0);
    assertEquals(0, list.getFirst());
  }

  @Test
  void get() {
    assertEquals(1, list.get(0));
    assertEquals(10, list.get(9));
    assertEquals(5, list.get(4));
    assertEquals(9, list.get(8));
  }

  @Test
  void removeFirst() {
    list.removeFirst();
    assertEquals(2, list.getFirst());
  }

  @Test
  void removeLast() {
    list.removeLast();
    assertEquals(9, list.getLast());
  }

  @Test
  void getFirst() {
    assertEquals(1, list.getFirst());
  }

  @Test
  void getLast() {
    assertEquals(10, list.getLast());
  }

  @Test
  void clean() {
    list.clean();
    assertEquals(0, list.size());
    assertThrows(IllegalStateException.class, () -> list.getFirst());
  }

  @Test
  void size() {
    assertEquals(10, list.size());
  }

  @Test
  void set() {
    list.set(100, 5);
    assertEquals(100, list.get(5));
  }

  @Test
  void setLast() {
    list.setLast(100);
    assertEquals(100, list.getLast());
  }

  @Test
  void setFirst() {
    list.setFirst(100);
    assertEquals(100, list.getFirst());
  }
}
