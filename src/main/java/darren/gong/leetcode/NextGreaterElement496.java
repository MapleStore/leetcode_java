package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement496 {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) {
      return new int[0];
    }
    int length = nums1.length;
    Stack<Integer> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>(2000);
    for (int num : nums2) {
      while (!stack.isEmpty() && stack.peek() < num) {
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }
    int[] result = new int[nums1.length];
    for (int i = 0; i < length; i++) {
      result[i] = map.getOrDefault(nums1[i], -1);
    }
    return result;
  }
}
