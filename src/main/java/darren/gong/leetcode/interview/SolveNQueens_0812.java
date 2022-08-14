package darren.gong.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SolveNQueens_0812 {
  private List<List<String>> result = new ArrayList<>();
  private boolean[] xVisited;
  private int n;
  private Set<Integer> positionKBs = new HashSet<>();
  private Set<Integer> negativeKBs = new HashSet<>();
  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    char[][] sbs = new char[n][n];
    xVisited = new boolean[n];
    for (int i = 0; i < n; i++) {
      sbs[i] = new char[n];
      Arrays.fill(sbs[i], '.');
    }
    dfs(sbs, 0);
    return result;
  }
  private void dfs(char[][] sbs, int y) {
    if (y >= sbs.length) {
      List<String> list = new LinkedList<>();
      for (char[] sb : sbs) {
        list.add(new String(sb));
      }
      result.add(list);
      return;
    }
    for (int x = 0; x < this.n; x++) {
      if (xVisited[x]) {
        continue;
      }
      int positiveKB = y-x;
      if (positionKBs.contains(positiveKB)) {
        continue;
      }
      int negativeKB = y+x;
      if (negativeKBs.contains(negativeKB)) {
        continue;
      }
      xVisited[x] = true;
      positionKBs.add(positiveKB);
      negativeKBs.add(negativeKB);
      sbs[y][x] = 'Q';
      dfs(sbs, y+1);
      sbs[y][x] = '.';
      xVisited[x] = false;
      positionKBs.remove(positiveKB);
      negativeKBs.remove(negativeKB);
    }
  }
}
