package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestAwesome_1542 {
  public static void main(String[] args) {
    LongestAwesome_1542 longestAwesome_1542 = new LongestAwesome_1542();
    longestAwesome_1542.longestAwesome("01630663");
  }
  public int longestAwesome(String s) {
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    int mask = 0;
    for (int i = 0; i < s.length(); i++) {
      mask ^= 1<<(s.charAt(i)-'0');
      if (valid(mask)) {
        result = i+1;
        map.putIfAbsent(mask, i);
        continue;
      }
      result = Math.max(result, i-map.getOrDefault(mask, 9999999));
      for (int j = 0; j <= 9; j++) {
        result = Math.max(result, i-map.getOrDefault(mask^(1<<j), 9999999));
      }
      map.putIfAbsent(mask, i);
    }
    return result;
  }
  private boolean valid(int mask) {
    if (mask == 0) {
      return true;
    }
    int count = 0;
    for (int i = 0; i <= 9; i++) {
      if ((mask&(1<<i)) != 0) {
        count++;
      }
    }
    return count <= 1;
  }
}
