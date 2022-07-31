package darren.gong.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class MaxQueue59 {
  private Deque<int[]> values = new LinkedList<>();
  private Deque<int[]> maxValues = new LinkedList<>();
  private int index = 0;
  public MaxQueue59() {

  }

  public int max_value() {
    if (maxValues.isEmpty()) {
      return -1;
    }
    return maxValues.peekFirst()[1];
  }

  public void push_back(int value) {
    values.addLast(new int[]{index, value});
    while (!maxValues.isEmpty() && maxValues.peekLast()[1] < value) {
      maxValues.pollLast();
    }
    maxValues.addLast(new int[]{index, value});
    index++;
  }

  public int pop_front() {
    if (values.isEmpty()) {
      return -1;
    }
    int[] current = values.pollFirst();
    if (!maxValues.isEmpty() && maxValues.peekFirst()[0] <= current[0]) {
      maxValues.pollFirst();
    }
    return current[1];
  }
}
