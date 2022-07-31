package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PhoneDirectory379 {
  private boolean[] used;
  private Queue<Integer> reuse = new LinkedList<>();
  private int useIndex = 0;
  private int maxNumbers;
  /** Initialize your data structure here
   @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
  public PhoneDirectory379(int maxNumbers) {
    used = new boolean[maxNumbers];
    this.maxNumbers = maxNumbers;
  }

  /** Provide a number which is not assigned to anyone.
   @return - Return an available number. Return -1 if none is available. */
  public int get() {
    if (!reuse.isEmpty()) {
      int result = reuse.poll();
      used[result] = true;
      return result;
    }
    if (useIndex >= maxNumbers) {
      return -1;
    }
    int result = useIndex;
    used[useIndex] = true;
    useIndex++;
    return result;
  }

  /** Check if a number is available or not. */
  public boolean check(int number) {
    return !used[number];
  }

  /** Recycle or release a number. */
  public void release(int number) {
    if (!used[number]) {
      return;
    }
    reuse.add(number);
    used[number] = false;
  }
}
