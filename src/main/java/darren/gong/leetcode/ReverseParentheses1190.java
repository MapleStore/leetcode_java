package darren.gong.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReverseParentheses1190 {
  public String reverseParentheses(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    Deque<Character> stack = new LinkedList<>();
    for (char one : s.toCharArray()) {
      if (one != ')') {
        stack.addLast(one);
      } else {
        List<Character> list = new LinkedList<>();
        while (stack.getLast() != '(') {
          list.add(stack.pollLast());
        }
        stack.pollLast();
        stack.addAll(list);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pollFirst());
    }
    return sb.toString();
  }
}
