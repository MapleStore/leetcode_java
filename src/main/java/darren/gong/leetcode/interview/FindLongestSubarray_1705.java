package darren.gong.leetcode.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarray_1705 {
  public static void main(String[] args) {
    FindLongestSubarray_1705 findLongestSubarray_1705 = new FindLongestSubarray_1705();
    findLongestSubarray_1705.findLongestSubarray(new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M","8"});
  }
  public String[] findLongestSubarray(String[] array) {
    // distance : index
    Map<Integer, Integer> counts = new HashMap<>();
    counts.put(0, -1);
    int distance = 0;
    int max = 0;
    int[] result = null;
    for (int i = 0; i < array.length; i++) {
      String val = array[i];
      if (isCharacter(val)) {
        distance++;
      } else {
        distance--;
      }
      Integer last = counts.get(distance);
      if (last != null && i-last > max) {
        max = i-last;
        result = new int[]{last, i};
      }
      counts.putIfAbsent(distance, i);
    }
    if (result == null) {
      return new String[0];
    }
    return Arrays.copyOfRange(array, result[0]+1, result[1]+1);
  }
  private boolean isCharacter(String s) {
    char one = s.charAt(0);
    return (one >= 'a' && one <= 'z') || (one >= 'A' && one <= 'Z');
  }
}
