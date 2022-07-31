package darren.gong.leetcode;

public class MyHashSet705 {
  public static void main(String[] args) {
    MyHashSet705 myHashSet705 = new MyHashSet705();
    myHashSet705.add(1);
    myHashSet705.add(2);
    myHashSet705.remove(2);
    myHashSet705.contains(2);
  }
  private int limit = 99999;
  private int mask = limit-1;
  private Entry[] array = new Entry[limit];
  private class Entry {
    private int value;
    private Entry next;
    Entry(int value) {
      this.value = value;
    }
  }
  /** Initialize your data structure here. */
  public MyHashSet705() {

  }

  public void add(int key) {
    int index = key%limit;
    Entry entry = array[index];
    if (entry == null) {
      array[index] = new Entry(key);
      return;
    }
    if (entry.value == key) {
      return;
    }
    while (entry.next != null && entry.next.value != key) {
      entry = entry.next;
    }
    if (entry.next == null) {
      entry.next = new Entry(key);
    }
    return;
  }

  public void remove(int key) {
    int index = key%limit;
    Entry entry = array[index];
    if (entry == null) {
      return;
    }
    if (entry.value == key) {
      array[index] = entry.next;
      return;
    }
    while (entry.next != null && entry.next.value != key) {
      entry = entry.next;
    }
    if (entry.next == null) {
      return;
    }
    entry.next = entry.next.next;
    return;
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int index = key%limit;
    Entry entry = array[index];
    while (entry != null) {
      if (entry.value == key) {
        return true;
      }
    }
    return false;
  }

}
