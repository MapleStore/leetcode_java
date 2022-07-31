package darren.gong.leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters316 {
  public String removeDuplicateLetters(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    int[] lastAppear = new int[26];
    for (int i = 0; i < s.length(); i++) {
      lastAppear[s.charAt(i)-'a'] = i;
    }
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char oneChar = s.charAt(i);
      if (stack.contains(oneChar)) {
        continue;
      }
      while (!stack.isEmpty() && oneChar < stack.peek() && lastAppear[stack.peek()-'a'] > i) {
        stack.pop();
      }
      stack.push(oneChar);
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}
