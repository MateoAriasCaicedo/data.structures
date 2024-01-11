package mateo.arias.data.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListTest {

  private ArrayList<Integer> arrayList;

  @BeforeEach
  void setup() {
    arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
  }

  @Test
  void add() {
    assertEquals(3, arrayList.size());

    assertEquals(1, arrayList.get(0));
    assertEquals(2, arrayList.get(1));
    assertEquals(3, arrayList.get(2));
  }

  @Test
  void remove() {
    arrayList.remove(0);

    assertEquals(2, arrayList.size());

    assertEquals(2, arrayList.get(0));
    assertEquals(3, arrayList.get(1));
  }

  @Test
  void insert() {
    arrayList.insert(0, 100);

    assertEquals(4, arrayList.size());

    assertEquals(100, arrayList.get(0));
    assertEquals(1, arrayList.get(1));
    assertEquals(2, arrayList.get(2));
    assertEquals(3, arrayList.get(3));
  }
}
