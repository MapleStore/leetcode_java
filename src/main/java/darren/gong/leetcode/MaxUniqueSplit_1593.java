package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSplit_1593 {
  private int max = 1;
  public int maxUniqueSplit(String s) {
    dfs(s, 0, new HashSet<>());
    return max;
  }
  private void dfs(String s, int currentIndex, Set<String> visited) {
    if (currentIndex >= s.length()) {
      max = Math.max(max, visited.size());
      return;
    }
    for (int end = currentIndex+1; end <= s.length(); end++) {
      String subStr = s.substring(currentIndex, end);
      if (visited.contains(subStr)) {
        continue;
      }
      visited.add(subStr);
      dfs(s, end, visited);
      visited.remove(subStr);
    }
  }
}
