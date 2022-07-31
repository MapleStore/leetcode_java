package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindMaximumXOR_421 {
  // 421. 数组中两个数的最大异或值
  public int findMaximumXOR(int[] nums) {
    int mask = 0;
    int result = 0;
    for (int i = 30; i >= 0; i--) {
      mask |= 1<<i;
      Set<Integer> allPrefix = new HashSet<>();
      for (int num : nums) {
        allPrefix.add(mask&num);
      }
      int temp = result|(1<<i);
      for (Integer prefix : allPrefix) {
        if (allPrefix.contains(prefix^temp)) {
          result = temp;
          break;
        }
      }
    }
    return result;
  }
}
