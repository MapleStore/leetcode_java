package darren.gong.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicates1209 {
  public String removeDuplicates(String s, int k) {
    Deque<int[]> stack = new LinkedList<>();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      if (stack.isEmpty() || stack.peekLast()[0] != s.charAt(i)) {
        stack.addLast(new int[]{s.charAt(i), 1});
      } else {
        int[] charAndAppear = stack.peekLast();
        charAndAppear[1]++;
        if (charAndAppear[1] == k) {
          stack.pollLast();
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      int[] charAndAppear = stack.pollFirst();
      while (charAndAppear[1]-- > 0) {
        sb.append((char)charAndAppear[0]);
      }
    }
    return sb.toString();
  }
}
