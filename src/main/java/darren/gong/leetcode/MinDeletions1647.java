package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinDeletions1647 {
  public int minDeletions(String s) {
    int[][] array = new int[26][2];
    for (int i = 0; i < 26; i++) {
      array[i][0] = 'a'+i;
    }
    char[] chars = s.toCharArray();
    for (char oneChar : chars) {
      array[oneChar-'a'][1]++;
    }
    Arrays.sort(array, (a, b)->b[1]-a[1]);
    Set<Integer> times = new HashSet<>();
    int result = 0;
    for (int i = 0; i < 26 && array[i][1] != 0; i++) {
      while (times.contains(array[i][1])) {
        array[i][1]--;
        result++;
      }
      if (array[i][1] != 0) {
        times.add(array[i][1]);
      }
    }
    return result;
  }
}
