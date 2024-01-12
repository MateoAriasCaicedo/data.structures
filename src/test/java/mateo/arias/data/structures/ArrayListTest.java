package mateo.arias.data.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListTest {

  private ArrayList<Integer> list;

  @BeforeEach
  void setup() {
    list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
  }

  @Test
  void add() {
    assertEquals(3, list.size());

    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  void remove() {
    list.remove(0);

    assertEquals(2, list.size());

    assertEquals(2, list.get(0));
    assertEquals(3, list.get(1));
  }

  @Test
  void insert() {
    list.insert(0, 100);

    assertEquals(4, list.size());

    assertEquals(100, list.get(0));
    assertEquals(1, list.get(1));
    assertEquals(2, list.get(2));
    assertEquals(3, list.get(3));
  }
}
