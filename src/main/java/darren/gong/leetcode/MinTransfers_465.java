package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinTransfers_465 {
  private int result = Integer.MAX_VALUE;
  public int minTransfers(int[][] transactions) {
    Map<Integer, Integer> money = new HashMap<>();
    for (int[] transaction : transactions) {
      int x = transaction[0];
      int y = transaction[1];
      int num = transaction[2];
      money.put(x, money.getOrDefault(x, 0)+num);
      money.put(y, money.getOrDefault(y, 0)-num);
    }
    List<Integer> getList = new ArrayList<>();
    List<Integer> payList = new ArrayList<>();
    for (Integer val : money.values()) {
      if (val > 0) {
        getList.add(val);
      }
      if (val < 0) {
        payList.add(-val);
      }
    }
    dfs(getList, payList, 0, 0);
    return result;
  }
  private void dfs(List<Integer> getList, List<Integer> payList, int start, int count) {
    if (start >= getList.size()) {
      result = Math.min(result, count);
      return;
    }
    for (int i = 0; i < payList.size(); i++) {
      if (payList.get(i) == 0) {
        continue;
      }
      int balance = Math.min(getList.get(start), payList.get(i));
      payList.set(i, payList.get(i)-balance);
      getList.set(start, getList.get(start)-balance);
      dfs(getList, payList, getList.get(start) == 0 ? start+1 : start, count+1);
      payList.set(i, payList.get(i)+balance);
      getList.set(start, getList.get(start)+balance);
    }
  }
}
