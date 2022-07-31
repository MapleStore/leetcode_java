package darren.gong.leetcode.interview;

import java.util.LinkedList;
import java.util.List;

public class Permutation_0807 {
  private List<String> allResult = new LinkedList<>();
  public String[] permutation(String S) {
    dfs(S, new boolean[S.length()], 0, new StringBuilder());
    String[] result = new String[this.allResult.size()];
    int index = 0;
    for (String oneResult : this.allResult) {
      result[index++] = oneResult;
    }
    return result;
  }
  private void dfs(String s, boolean[] visited, int visitedNum, StringBuilder sb) {
    if (visitedNum == s.length()) {
      allResult.add(sb.toString());
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      sb.append(s.charAt(i));
      dfs(s, visited, visitedNum+1, sb);
      visited[i] = false;
      sb.deleteCharAt(sb.length()-1);
    }
  }
}
