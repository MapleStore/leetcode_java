package darren.gong.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PeekingIterator284 implements Iterator {
  private Iterator<Integer> iterator;
  private Integer cache;
  public PeekingIterator284(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    if (cache != null) {
      return cache;
    }
    Integer value = iterator.next();
    cache = value;
    return value;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    if (cache != null) {
      Integer temp = cache;
      cache = null;
      return temp;
    }
    return iterator.next();
  }

  @Override
  public boolean hasNext() {
    if (cache != null) {
      return true;
    }
    return iterator.hasNext();
  }
}
