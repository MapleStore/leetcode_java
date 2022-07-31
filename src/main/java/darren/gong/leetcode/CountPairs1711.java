package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountPairs1711 {
  private long mod = (long)Math.pow(10, 9)+7;
  public int countPairs(int[] deliciousness) {
    Map<Integer, Integer> counts = new HashMap<>();
    boolean[] visited = new boolean[(1<<21)+1];
    long result = 0;
    for (int delicious : deliciousness) {
      counts.put(delicious, counts.getOrDefault(delicious, 0)+1);
    }
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      int delicious = entry.getKey();
      visited[delicious] = true;
      int deliciousCount = entry.getValue();
      for (int i = 0; i < 22; i++) {
        int pairDelicious = (1<<i)-delicious;
        if (pairDelicious < 0) {
          continue;
        }
        if (pairDelicious == delicious) {
          result += (long)deliciousCount*((long)deliciousCount-1)/2;
        } else if (!visited[pairDelicious]) {
          int pairCount = counts.getOrDefault(pairDelicious, 0);
          result += pairCount*deliciousCount;
        }
        result %= mod;
      }
    }
    return (int)result;
  }
}
