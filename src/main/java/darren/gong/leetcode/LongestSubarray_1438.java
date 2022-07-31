package darren.gong.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LongestSubarray_1438 {
  public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> increase = new LinkedList<>();
    Deque<Integer> decrease = new LinkedList<>();
    int right = 0;
    int left = 0;
    int length = nums.length;
    int result = 0;
    while (right < length) {
      int val = nums[right];
      while (!increase.isEmpty() && increase.peekLast() > val) {
        increase.pollLast();
      }
      increase.addLast(val);

      while (!decrease.isEmpty() && decrease.peekLast() < val) {
        decrease.pollLast();
      }
      decrease.addLast(val);

      while (!increase.isEmpty() && !decrease.isEmpty() && decrease.peekFirst()-increase.peekFirst() > limit) {
        int leftVal = nums[left];
        if (leftVal == increase.peekFirst()) {
          increase.pollFirst();
        }
        if (leftVal == decrease.peekFirst()) {
          decrease.pollFirst();
        }
        left++;
      }
      result = Math.max(result, right-left+1);
      right++;
    }
    return result;
  }
}
