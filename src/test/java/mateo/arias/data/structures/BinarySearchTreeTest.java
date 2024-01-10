package mateo.arias.data.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {

  BinarySearchTree tree;

  @BeforeEach
  void setup() {
    tree = new BinarySearchTree();
  }

  @Test
  public void testAddContains() {
    int testNumber = 3;

    tree.add(testNumber);
    boolean successfullyAdded = tree.contains(testNumber);

    assertTrue(successfullyAdded);
  }

  @Test
  public void testToList() {
    int treeNodes = 5;

    List<Integer> expectedList = new ArrayList<>();
    for (int i = 0; i < treeNodes; i++) {
      tree.add(i);
      expectedList.add(i);
    }

    List<Integer> treeList = tree.toList();
    for (int i = 0; i < treeNodes; i++) {
      assertEquals(expectedList.get(i), treeList.get(i));
    }
  }
}
