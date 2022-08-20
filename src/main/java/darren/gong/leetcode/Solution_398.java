package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution_398 {
  private Map<Integer, ArrayList<Integer>> map = new HashMap<>();
  private Random random = new Random();
  public Solution_398(int[] nums) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
    }
  }

  public int pick(int target) {
    ArrayList<Integer> list = map.get(target);
    return list.get(Math.abs(random.nextInt())%list.size());
  }
}
