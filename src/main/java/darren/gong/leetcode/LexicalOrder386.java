package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LexicalOrder386 {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new LinkedList<>();
    dfs(result, n, 0);
    return result;
  }
  private void dfs(List<Integer> result, int n, int pre) {
    for (int i = 0; i <= 9; i++) {
      int current = pre * 10 + i;
      if (current != 0 && current <= n) {
        result.add(current);
        dfs(result, n, current);
      }
    }
    return;
  }
}
