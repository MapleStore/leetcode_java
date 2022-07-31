package darren.gong.leetcode;

public class MinCost1578 {
  public int minCost(String s, int[] cost) {
    if (cost == null || cost.length <= 1) {
      return 0;
    }
    char[] array = s.toCharArray();
    int result = 0;
    int i = 0;
    int j = 1;
    while (j < array.length) {
      if (array[i] == array[j]) {
        if (cost[i] > cost[j]) {
          result += cost[j];
        } else {
          result += cost[i];
          i = j;
        }
      } else {
        i = j;
      }
      j++;
    }
    return result;
  }
}
