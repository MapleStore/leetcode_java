package darren.gong.leetcode;

import java.util.List;
import java.util.Stack;

public class FindDiagonalOrder_1424II {
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    int maxX = nums.size();
    int maxY = 0;
    for (List<Integer> row : nums) {
      maxY = Math.max(maxY, row.size());
    }

    Stack<Integer>[] stacks = new Stack[maxX+maxY-1];
    for (int i = 0; i < maxX+maxY-1; i++) {
      stacks[i] = new Stack<>();
    }
    for (int i = 0; i < maxX; i++) {
      List<Integer> row = nums.get(i);
      int length = row.size();
      for (int j = 0; j < length; j++) {
        stacks[i+j].push(row.get(j));
      }
    }
    int resultSize = 0;
    for (Stack<Integer> stack : stacks) {
      resultSize += stack.size();
    }
    int[] result = new int[resultSize];
    int index = 0;
    for (Stack<Integer> stack : stacks) {
      while (!stack.isEmpty()) {
        result[index++] = stack.pop();
      }
    }
    return result;
  }
}
