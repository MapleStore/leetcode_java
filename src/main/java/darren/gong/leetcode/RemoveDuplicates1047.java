package darren.gong.leetcode;

import java.util.Stack;

public class RemoveDuplicates1047 {
  public String removeDuplicates(String S) {
    Stack<Character> stack = new Stack<>();
    for (char oneChar : S.toCharArray()) {
      if (!stack.isEmpty() && stack.peek() == oneChar) {
        stack.pop();
      } else {
        stack.push(oneChar);
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}
