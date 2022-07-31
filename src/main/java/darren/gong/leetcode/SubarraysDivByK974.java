package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK974 {
  public int subarraysDivByK(int[] A, int K) {
    if (A == null || A.length == 0) {
      return 0;
    }
    Map<Integer, Integer> record = new HashMap<>();
    record.put(0,1);
    int positive = K*1000000;
    int sum = 0;
    int result = 0;
    for (int num : A) {
      sum += num;
      int mod = sum%K;
      if (sum<0) {
        mod = (sum+((-sum)/K)*K+K)%K;
      }
      int preSameMod = record.getOrDefault(mod, 0);
      result += preSameMod;
      record.put(mod, preSameMod+1);
    }
    return result;
  }
}
