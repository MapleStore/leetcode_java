package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Find132pattern456 {
  public static void main(String[] args) {
    Find132pattern456 find132pattern456 = new Find132pattern456();
    find132pattern456.find132patternN2(new int[]{1,0,1,-4,-3});
  }
  public boolean find132patternN2(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }
    int length = nums.length;
    int[][] temp = new int[length][2];
    int min = nums[0];
    for (int i = 0; i < length; i++) {
      min = Math.min(min, nums[i]);
      temp[i][0] = min;
      temp[i][1] = nums[i];
    }

    for (int i = 2; i < length; i++) {
      for (int j = 1; j < i; j++) {
        if (nums[i] > temp[j][0] && nums[i] < temp[j][1]) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean find132pattern(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }
    int length = nums.length;
    Stack<Integer> stack = new Stack<>();
    int secMax = Integer.MIN_VALUE;
    for (int i = length-1; i >= 0; i--) {
      if (secMax > nums[i]) {
        return true;
      }
      while (!stack.empty() && stack.peek() < nums[i]) {
        secMax = stack.pop();
      }
      stack.push(nums[i]);
    }
    return false;
  }

}
