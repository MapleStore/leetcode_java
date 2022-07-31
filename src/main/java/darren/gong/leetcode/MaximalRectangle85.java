package darren.gong.leetcode;

import java.util.Stack;

public class MaximalRectangle85 {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int maxX = matrix.length;
    int maxY = matrix[0].length;
    int[] height = new int[maxY];
    int result = 0;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (matrix[i][j] == '1') {
          height[j] += 1;
        } else {
          height[j] = 0;
        }
      }
      result = Math.max(result, largestRectangleArea(height));
    }
    return result;
  }

  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int length = heights.length;
    int result = 0;
    stack.push(-1);
    for (int i = 0; i < length; i++) {
      int preIndex = stack.peek();
      while (preIndex != -1 && heights[i] < heights[preIndex]) {
        result = Math.max(result, heights[stack.pop()]*(i-(preIndex = stack.peek())-1));
      }
      stack.push(i);
    }
    int preIndex = stack.peek();
    while (preIndex != -1) {
      result = Math.max(result, heights[stack.pop()]*(length-(preIndex = stack.peek())-1));
    }
    return result;
  }

}
