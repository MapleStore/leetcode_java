package darren.gong.leetcode.race;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEven {
  public static void main(String[] args) {
    MostFrequentEven mostFrequentEven = new MostFrequentEven();
    mostFrequentEven.mostFrequentEven(new int[]{8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290});
  }
  public int mostFrequentEven(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (num%2 != 0) {
        continue;
      }
      map.put(num, map.getOrDefault(num, 0)+1);
    }
    int count = -1;
    int result = -1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == count && entry.getKey() < result) {
        result = entry.getKey();
      } else if (entry.getValue() > count) {
        count = entry.getValue();
        result = entry.getKey();
      }
    }
    return result;
  }
}
