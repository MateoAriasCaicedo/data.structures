package mateo.arias.data.structures;

public class ArrayList<T> {

  private Object[] innerArray;

  private int currentSize;

  private static final int DEFAULT_SIZE = 10;

  public ArrayList() {
    innerArray = new Object[DEFAULT_SIZE];
    currentSize = 0;
  }

  public ArrayList(int initialSize) {
    innerArray = new Object[initialSize];
    currentSize = 0;
  }

  public void add(T object) {
    if (currentSize == innerArray.length) {
      innerArray = growInnerArray(duplicateSize(currentSize), currentSize, innerArray);
    }

    innerArray[currentSize] = object;
    currentSize++;
  }

  private static Object[] growInnerArray(int newSize, int currentSize, Object[] oldArray) {
    Object[] newArray = new Object[newSize];
    System.arraycopy(oldArray, 0, newArray, 0, currentSize);
    return newArray;
  }

  private static int duplicateSize(int size) {
    return size * 2;
  }

  private static boolean indexIsOutOfBounds(int index, int arraySize) {
    return index >= arraySize || index < 0;
  }

  public void set(int index, T object) {
    if (indexIsOutOfBounds(index, currentSize)) {
      throw new IndexOutOfBoundsException();
    }

    innerArray[index] = object;
  }

  public T get(int index) {
    if (indexIsOutOfBounds(index, currentSize)) {
      throw new IndexOutOfBoundsException();
    }

    return (T) innerArray[index];
  }

  public void remove(int index) {
    if (indexIsOutOfBounds(index, currentSize)) {
      throw new IndexOutOfBoundsException();
    }

    for (int i = index; i < currentSize - 1; i++) {
      innerArray[i] = innerArray[i + 1];
    }

    innerArray[currentSize] = 0;
    currentSize--;
  }

  public void insert(int index, T object) {
    if (index > currentSize || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    if (index == currentSize) {
      growInnerArray(duplicateSize(currentSize), currentSize, innerArray);
    }

    for (int i = currentSize; i > index; i--) {
      innerArray[i] = innerArray[i - 1];
    }

    innerArray[index] = object;
    currentSize++;
  }

  public int size() {
    return currentSize;
  }
}
