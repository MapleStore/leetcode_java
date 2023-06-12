package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountRoutes_1575 {
  public static void main(String[] args) {
    CountRoutes_1575 countRoutes_1575 = new CountRoutes_1575();
    countRoutes_1575.countRoutes(new int[]{2,3,6,8,4}, 1, 3, 5);
  }
  private final int MOD = 1000000007;
  private Map<Integer, Integer> map = new HashMap<>();
  private int maxFuel;
  public int countRoutes(int[] locations, int start, int finish, int fuel) {
    if (Math.abs(locations[start]-locations[finish]) > fuel) {
      return 0;
    }
    maxFuel = fuel;
    long result = 0;
    for (int i = 0; i < fuel; i++) {
      result += dfs(locations, start, finish, i);
    }
    if (start == finish) {
      result++;
    }
    result %= MOD;
    return (int) result;
  }
  private int dfs(int[] locations, int start, int current, int fuel) {
    if (fuel > maxFuel) {
      return 0;
    }
    if (current == start && fuel == maxFuel) {
      return 1;
    }
    int key = current*(maxFuel+1)+fuel;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    long result = 0;
    for (int i = 0; i < locations.length; i++) {
      if (locations[i] == locations[current]) {
        continue;
      }
      result += dfs(locations, start, i, fuel+Math.abs(locations[i]-locations[current]));
    }
    result %= MOD;
    map.put(key, (int) result);
    return (int) result;
  }
}
