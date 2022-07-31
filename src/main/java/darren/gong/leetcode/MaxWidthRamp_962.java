package darren.gong.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxWidthRamp_962 {
  public static void main(String[] args) {
    MaxWidthRamp_962 maxWidthRamp_962 = new MaxWidthRamp_962();
    maxWidthRamp_962.maxWidthRamp(new int[]{6,0,8,2,1,5});
  }
  public int maxWidthRamp(int[] nums) {
    Stack<int[]> leftStack = new Stack<>();
    Deque<int[]> rightStack = new LinkedList<>();
    int length = nums.length;

    for (int i = 0; i < length; i++) {
      if (leftStack.isEmpty() || leftStack.peek()[1] > nums[i]) {
        leftStack.push(new int[]{i, nums[i]});
      }
    }
    for (int i = length-1; i >= 0; i--) {
      if (rightStack.isEmpty() || rightStack.peekLast()[1] < nums[i]) {
        rightStack.addLast(new int[]{i, nums[i]});
      }
    }

    int result = 0;
    while (!rightStack.isEmpty()) {
      int[] right = rightStack.pollFirst();
      while (!leftStack.isEmpty() && right[1] >= leftStack.peek()[1]) {
        result = Math.max(result, right[0]-leftStack.pop()[0]);
      }
      if (leftStack.isEmpty()) {
        break;
      }
    }
    return result;
  }
}
