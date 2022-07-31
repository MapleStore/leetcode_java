package darren.gong.leetcode.race;

import java.util.HashMap;
import java.util.Map;

public class TupleSameProduct {
  public static void main(String[] args) {
    TupleSameProduct tupleSameProduct = new TupleSameProduct();
    tupleSameProduct.tupleSameProduct(new int[]{2,3,4,6});
  }
  public int tupleSameProduct(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      for (int j = i+1; j < length; j++) {
        int value = nums[i]*nums[j];
        map.put(value, map.getOrDefault(value, 0)+1);
      }
    }

    int result = 0;
    for (int num : map.values()) {
      if (num == 1) {
        continue;
      }
      result += (num*(num-1))*4;
    }
    return result;
  }
}
