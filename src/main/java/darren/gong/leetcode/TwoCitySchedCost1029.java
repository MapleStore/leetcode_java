package darren.gong.leetcode;

import java.util.Arrays;

public class TwoCitySchedCost1029 {
  public static void main(String[] args) {
    TwoCitySchedCost1029 twoCitySchedCost1029 = new TwoCitySchedCost1029();
    twoCitySchedCost1029.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}});
  }
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, (a, b)->((b[1]-b[0])-(a[1]-a[0])));
    int length = costs.length;
    int half = length>>>1;
    int result = 0;
    for (int i = 0; i < length; i++) {
      result += i < half ? costs[i][0] : costs[i][1];
    }
    return result;
  }
}
