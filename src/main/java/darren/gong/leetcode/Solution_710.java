package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Solution_710 {
  public static void main(String[] args) {
    Solution_710 solution_710 = new Solution_710(4, new int[]{3,1});
    solution_710.pick();
    solution_710.pick();
    solution_710.pick();
    solution_710.pick();
    solution_710.pick();
  }
  private Random random = new Random();
  private Map<Integer, Integer> changeMap = new HashMap<>();
  private Set<Integer> set = new HashSet<>();
  private int n;
  public Solution_710(int n, int[] blacklist) {
    this.n = n;
    for (int blackVal : blacklist) {
      set.add(blackVal);
    }
    Arrays.sort(blacklist);
    for (int i = 0; i < blacklist.length; i++) {
      while (set.contains(this.n-1)) {
        this.n--;
      }
      if (this.n <= blacklist[i]) {
        break;
      }
      changeMap.put(blacklist[i], this.n-1);
      set.add(this.n-1);
      set.remove(blacklist[i]);
    }
  }

  public int pick() {
    if (n == 0) {
      return 0;
    }
    int num = random.nextInt(n);
    if (changeMap.containsKey(num)) {
      return changeMap.get(num);
    }
    return num;
  }
}
