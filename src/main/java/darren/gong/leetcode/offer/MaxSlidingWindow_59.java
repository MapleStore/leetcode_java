package darren.gong.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_59 {
  public static void main(String[] args) {
    MaxSlidingWindow_59 maxSlidingWindow_59 = new MaxSlidingWindow_59();
    maxSlidingWindow_59.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
  }
  public int[] maxSlidingWindow(int[] nums, int k) {
    int length = nums.length;
    if (length == 0) {
      return new int[0];
    }
    int[] result = new int[length-k+1];
    int resultIndex = 0;
    Deque<int[]> deque = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      int num = nums[i];
      while (!deque.isEmpty() && deque.peekFirst()[0]+k <= i) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && deque.peekLast()[1] <= num) {
        deque.pollLast();
      }
      deque.addLast(new int[]{i, num});
      if (i >= k-1) {
        result[resultIndex++] = deque.peekFirst()[1];
      }
    }
    return result;
  }

}
