package darren.gong.leetcode;

import java.util.Stack;

public class ScoreOfParentheses_856 {
  public int scoreOfParentheses(String S) {
    Stack<Integer> stack = new Stack<>();
    for (char oneChar : S.toCharArray()) {
      if (oneChar == '(') {
        stack.push(Integer.MIN_VALUE);
      } else {
        int midNum = 0;
        int preValue;
        while ((preValue = stack.pop()) != Integer.MIN_VALUE) {
          midNum += preValue;
        }
        if (midNum != 0) {
          stack.push(2*midNum);
        } else {
          stack.push(1);
        }
      }
    }
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }
    return result;
  }
}
