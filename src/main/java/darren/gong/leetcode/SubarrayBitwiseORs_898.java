package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SubarrayBitwiseORs_898 {
  public int subarrayBitwiseORs(int[] arr) {
    Set<Integer> result = new HashSet<>(arr.length);
    Set<Integer> current = new HashSet<>(32);
    current.add(0);

    for (int value : arr) {
      Set<Integer> nextCurrent = new HashSet<>(32);
      for (int pre : current) {
        nextCurrent.add(pre|value);
      }
      result.addAll(nextCurrent);
      current = nextCurrent;
      current.add(0);
    }
    return result.size();
  }
}
