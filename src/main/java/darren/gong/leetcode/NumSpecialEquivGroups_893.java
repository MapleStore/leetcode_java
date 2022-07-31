package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class NumSpecialEquivGroups_893 {
  public int numSpecialEquivGroups(String[] words) {
    List<int[][]> list = new LinkedList<>();
    int result = 0;
    for (String word : words) {
      int[] count0 = getCount(word, 0);
      int[] count1 = getCount(word, 1);
      boolean isSame = false;
      for (int[][] oneCounts : list) {
        if (same(count0, oneCounts[0]) && same(count1, oneCounts[1])) {
          isSame = true;
        }
      }
      if (!isSame) {
        result++;
        list.add(new int[][]{count0, count1});
      }
    }
    return result;
  }
  private int[] getCount(String word, int mod) {
    int[] counts = new int[26];
    for (int i = 0; i < word.length(); i++) {
      if (i%2 == mod) {
        counts[word.charAt(i)-'a']++;
      }
    }
    return counts;
  }
  private boolean same(int[] a, int[] b) {
    for (int i = 0; i < 26; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }
}
