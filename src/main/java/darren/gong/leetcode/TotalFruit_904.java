package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit_904 {
  public int totalFruit(int[] fruits) {
    int length = fruits.length;
    int left = 0;
    int right = 0;
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    while (right < length) {
      int fruit = fruits[right];
      map.put(fruit, map.getOrDefault(fruit, 0)+1);
      while (map.size() > 2) {
        int removeFruit = fruits[left];
        int count = map.get(removeFruit);
        count--;
        if (count == 0) {
          map.remove(removeFruit);
        } else {
          map.put(removeFruit, count);
        }
        left++;
      }
      result = Math.max(result, right-left+1);
      right++;
    }
    return result;
  }
}
