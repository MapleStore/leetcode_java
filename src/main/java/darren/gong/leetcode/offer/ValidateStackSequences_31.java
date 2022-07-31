package darren.gong.leetcode.offer;

import java.util.Stack;

public class ValidateStackSequences_31 {
  // 剑指 Offer 31. 栈的压入、弹出序列
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int popIndex = 0;
    Stack<Integer> stack = new Stack<>();
    for (int push : pushed) {
      stack.push(push);
      while (!stack.isEmpty() && popped[popIndex] == stack.peek()) {
        stack.pop();
        popIndex++;
      }
    }
    return popIndex >= popped.length;
  }
}
