package darren.gong.leetcode.race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VolunteerDeployment {
  public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
    int n = finalCnt.length + 1, m = plans.length;
    long[] oriParam = new long[n];
    long[] oriCnt = new long[n];
    oriParam[0] = 1;
    for (int i = 0; i < n - 1; i++) {
      oriCnt[i + 1] = finalCnt[i];
    }
    HashMap<Integer, List<Integer>> related = new HashMap<>();
    for (int[] e : edges) {
      addRelations(e[0], e[1], related);
      addRelations(e[1], e[0], related);
    }
    for (int i = m - 1; i >= 0; i--) {
      int idx = plans[i][1];
      int num = plans[i][0];
      operate(num, idx, oriParam, related);
      operate(num, idx, oriCnt, related);
    }
    long param = 0;
    for (int i = 0; i < n; i++) {
      totalNum -= oriCnt[i];
      param += oriParam[i];
    }
    long x = totalNum / param;
    for (int i = 0; i < n; i++) {
      oriCnt[i] += oriParam[i] * x;
    }
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = (int) oriCnt[i];
    }
    return res;
  }

  private void operate(int num, int idx, long[] array, HashMap<Integer, List<Integer>> related) {
    if (num == 1) {
      array[idx] *= 2;
      return;
    }
    for (int r : related.get(idx)) {
      if (num == 2) {
        array[r] -= array[idx];
      } else {
        array[r] += array[idx];
      }
    }
  }

  private void addRelations(int x, int y, HashMap<Integer, List<Integer>> related) {
    List<Integer> relations = related.computeIfAbsent(x, k->new ArrayList<>());
    relations.add(y);
  }
}
