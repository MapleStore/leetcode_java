package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetFactors_254 {
  // 254. 因子的组合
  List<List<Integer>> result = new LinkedList<>();
  public List<List<Integer>> getFactors(int n) {
    backTracking(2, n, new ArrayList<>());
    return result;
  }
  private void backTracking(int start, int need, List<Integer> oneResult) {
    for (int i = start; i <= (int)Math.sqrt(need); i++) {
      if (need%i != 0) {
        continue;
      }
      oneResult.add(i);

      oneResult.add(need/i);
      result.add(new ArrayList<>(oneResult));
      oneResult.remove(oneResult.size()-1);

      backTracking(i, need/i, oneResult);
      oneResult.remove(oneResult.size()-1);
    }
    return;
  }
}
