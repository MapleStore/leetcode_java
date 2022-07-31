package darren.gong.leetcode;

import java.util.Stack;

public class LargestRectangleArea84 {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int length = heights.length;
    int result = 0;
    stack.push(-1);
    for (int i = 0; i < heights.length; i++) {
      int lastIndex = stack.peek();
      while (lastIndex != -1 && heights[i] < heights[lastIndex]) {
        result = Math.max(heights[stack.pop()]*(i - (lastIndex = stack.peek()) - 1), result);
      }
      stack.push(i);
    }
    int lastIndex = stack.peek();
    while (lastIndex != -1) {
      result = Math.max(result, heights[stack.pop()] * (length-(lastIndex = stack.peek())-1));
    }
    return result;
  }
}
