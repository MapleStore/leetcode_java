package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class SmallestSubsequence_1081 {
  public static void main(String[] args) {
    SmallestSubsequence_1081 smallestSubsequence_1081 = new SmallestSubsequence_1081();
    smallestSubsequence_1081.smallestSubsequence("bcabc");
  }
  public String smallestSubsequence(String s) {
    Stack<Character> stack = new Stack<>();
    int[] lastIndex = new int[26];
    Arrays.fill(lastIndex, -1);
    int length = s.length();
    for (int i = 0; i < length; i++) {
      lastIndex[s.charAt(i)-'a'] = i;
    }
    boolean[] visited = new boolean[26];
    for (int i = 0; i < length; i++) {
      char current = s.charAt(i);
      if (visited[current-'a']) {
        continue;
      }
      visited[current-'a'] = true;
      while (!stack.empty() && stack.peek() > current && lastIndex[stack.peek()-'a'] > i) {
        visited[stack.pop()-'a'] = false;
      }
      stack.push(current);
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}
