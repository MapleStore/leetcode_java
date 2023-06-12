package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNiceDivisors_1808 {
  public static void main(String[] args) {
    MaxNiceDivisors_1808 maxNiceDivisors_1808 = new MaxNiceDivisors_1808();
    maxNiceDivisors_1808.maxNiceDivisors(3);
  }
  private final long MOD = 1000000007;
  public int maxNiceDivisors(int primeFactors) {
    if (primeFactors <= 4) {
      return primeFactors;
    }
    long result;
    if (primeFactors%3 == 1) {
      result = (count(3, primeFactors/3-1)*4)%MOD;
    } else if (primeFactors%3 == 2) {
      result = (count(3, primeFactors/3)*2)%MOD;
    } else {
      result = count(3, primeFactors/3)%MOD;
    }
    return (int) result;
  }
  Map<Long, Long> map = new HashMap<>();
  private long count(long val, long times) {
    if (map.containsKey(times)) {
      return map.get(times);
    }
    if (times == 1) {
      return val;
    }
    long result = (count(val, times/2)*count(val, times/2))%MOD;
    if (times%2 == 1) {
      result *= val;
    }
    map.put(times, result%MOD);
    return result%MOD;
  }
}
