package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumRabbits_781 {
  // 781. 森林中的兔子
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int answer : answers) {
      map.put(answer, map.getOrDefault(answer, 0)+1);
    }
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int otherSame = entry.getKey();
      int minNum = otherSame+1;
      int count = entry.getValue();
      result += count%minNum == 0 ? count : minNum*(count/minNum+1);
    }
    return result;
  }
}
