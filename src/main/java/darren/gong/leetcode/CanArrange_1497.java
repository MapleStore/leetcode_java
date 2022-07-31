package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanArrange_1497 {
  // 1497. 检查数组对是否可以被 k 整除
  public static void main(String[] args) {
    CanArrange_1497 canArrange_1497 = new CanArrange_1497();
    canArrange_1497.canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5);
  }
  public boolean canArrange(int[] arr, int k) {
    int[] map = new int[k];
    for (int value : arr) {
      int rest = value%k;
      if (rest < 0) {
        rest += k;
      }
      map[rest]++;
    }
    if (map[0]%2 != 0) {
      return false;
    }

    for (int i = 1; i < k; i++) {
      int against = k-i;
      if (map[i] != map[against]) {
        return false;
      }
    }
    return true;
  }
}
