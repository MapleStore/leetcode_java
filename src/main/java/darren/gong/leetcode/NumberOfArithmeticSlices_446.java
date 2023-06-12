package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfArithmeticSlices_446 {
  public static void main(String[] args) {
    NumberOfArithmeticSlices_446 numberOfArithmeticSlices_446 = new NumberOfArithmeticSlices_446();
    numberOfArithmeticSlices_446.numberOfArithmeticSlices(new int[]{0,2000000000,-294967296});
  }
  public int numberOfArithmeticSlices(int[] nums) {
    int length = nums.length;
    Map<Long, int[]>[] counts = new Map[length];
    for (int i = 0; i < length; i++) {
      counts[i] = new HashMap<Long, int[]>();
    }
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < i; j++) {
        long distance = (long)nums[i]-(long)nums[j];
        int[] pre = counts[j].getOrDefault(distance, new int[4]);
        pre[1] = 1;
        int[] current = counts[i].computeIfAbsent(distance, k->new int[4]);
        current[2] += pre[1];
        current[3] += pre[2]+pre[3];
      }
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      for (int[] vals : counts[i].values()) {
        result += vals[3];
      }
    }
    return result;
  }
}
