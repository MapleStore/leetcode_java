package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CanMakePaliQueries_1177 {
  // 1177. 构建回文串检测
  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    List<Boolean> result = new LinkedList<>();
    int length = s.length();
    if (length == 0) {
      return result;
    }
    int[][] prefix = new int[length][];
    prefix[0] = new int[26];
    prefix[0][s.charAt(0)-'a']++;
    for (int i = 1; i < length; i++) {
      prefix[i] = Arrays.copyOf(prefix[i-1], 26);
      prefix[i][s.charAt(i)-'a']++;
    }
    for (int[] query : queries) {
      int left = query[0];
      int right = query[1];
      int k = query[2];
      int[] count = left == 0 ? prefix[right] : getCount(prefix[left-1], prefix[right]);
      if (canParse(count, right-left+1, k)) {
        result.add(true);
      } else {
        result.add(false);
      }
    }
    return result;
  }

  private int[] getCount(int[] left, int[] right) {
    int[] result = new int[26];
    for (int i = 0; i < 26; i++) {
      result[i] = right[i]-left[i];
    }
    return result;
  }
  private boolean canParse(int[] count, int length, int k) {
    if (length % 2 == 0) {
      int distance = 0;
      for (int i = 0; i < 26; i++) {
        distance += count[i]%2;
      }
      return k >= distance/2;
    } else {
      int distance = 0;
      for (int i = 0; i < 26; i++) {
        distance += count[i]%2;
      }
      return k >= (distance-1)/2;
    }
  }
}
