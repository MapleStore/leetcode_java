package darren.gong.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinMutation_433 {
  public int minMutation(String start, String end, String[] bank) {
    int length = bank.length;
    boolean[] visited = new boolean[length];
    int result = 0;
    Queue<String> queue = new LinkedList<>();
    queue.add(start);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String current = queue.poll();
        for (int i = 0; i < length; i++) {
          if (visited[i]) {
            continue;
          }
          String word = bank[i];
          if (word.equals(start)) {
            visited[i] = true;
            continue;
          }
          if (!isConnect(current, word)) {
            continue;
          }
          if (word.equals(end)) {
            return result+1;
          }
          visited[i] = true;
          queue.add(word);
        }
      }
      result++;
    }
    return -1;
  }
  private boolean isConnect(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }
    int count = 0;
    int length = word1.length();
    for (int i = 0; i < length; i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        if (count != 0) {
          return false;
        }
        count++;
      }
    }
    return true;
  }
}
