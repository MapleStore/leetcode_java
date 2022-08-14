package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections_1192 {
  private int[] low;
  private int[] dfn;
  private boolean[] pointVisited;
  private List<Integer>[] map;
  private int index = 0;
  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    low = new int[n];
    dfn = new int[n];
    pointVisited = new boolean[n];
    map = new List[n];
    for (int i = 0; i < n; i++) {
      map[i] = new ArrayList();
    }
    for (List<Integer> connection : connections) {
      int pointOne = connection.get(0);
      int pointTwo = connection.get(1);
      map[pointOne].add(pointTwo);
      map[pointTwo].add(pointOne);
    }
    tarjan(0, -1);
    return result;
  }
  private void tarjan(int point, int parent) {
    pointVisited[point] = true;
    low[point] = dfn[point] = index++;
    for (int index = 0; index < map[point].size(); index++) {
      int next = map[point].get(index);
      if (!pointVisited[next]) {
        tarjan(next, point);
        low[point] = Math.min(low[point], low[next]);
        if (low[next] > dfn[point]) {
          result.add(Arrays.asList(point, next));
        }
      } else if (next != parent) {
        low[point] = Math.min(low[point], dfn[next]);
      }
    }
  }
}
