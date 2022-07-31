package darren.gong.leetcode.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation38 {
  private List<String> result = new LinkedList<>();
  public String[] permutation(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    dfs(chars, new StringBuilder(), new boolean[chars.length]);
    String[] realResult = new String[result.size()];
    return result.toArray(realResult);
  }
  private void dfs(char[] chars, StringBuilder sb, boolean[] visited) {
    if (sb.length() == chars.length) {
      result.add(sb.toString());
      return;
    }
    for (int i = 0; i < chars.length; i++) {
      if (visited[i]) {
        continue;
      }
      if (i != 0 && chars[i] == chars[i-1] && !visited[i-1]) {
        continue;
      }
      sb.append(chars[i]);
      visited[i] = true;
      dfs(chars, sb, visited);
      visited[i] = false;
      sb.deleteCharAt(sb.length()-1);
    }
  }
}
