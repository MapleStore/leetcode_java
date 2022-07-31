package darren.gong.leetcode;

import java.util.Stack;

public class MaxChunksToSorted768 {
  public int maxChunksToSorted(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    Stack<Integer> stack = new Stack<>();
    int length = arr.length;
    for (int i = 0; i < length; i++) {
      int max = arr[i];
      while (!stack.isEmpty() && stack.peek() > arr[i]) {
        max = Math.max(max, stack.pop());
      }
      stack.add(max);
    }
    return stack.size();
  }
}
