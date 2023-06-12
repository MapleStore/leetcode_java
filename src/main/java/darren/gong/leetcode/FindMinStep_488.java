package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindMinStep_488 {
  public static void main(String[] args) {
    FindMinStep_488 findMinStep_488 = new FindMinStep_488();
    findMinStep_488.findMinStep("RRWWRRBBRR",
        "WB");
  }
  private Map<String, Integer> cache = new HashMap<>();
  public int findMinStep(String board, String hand) {
    int result = findMinStep(new StringBuilder(board), hand, 0);
    return result == Integer.MAX_VALUE ? -1 : result;
  }
  private int findMinStep(StringBuilder board, String hand, int handMask) {
    if (board.length() == 0) {
      return 0;
    }
    if (handMask >= 1<<hand.length()-1) {
      return Integer.MAX_VALUE;
    }
    String key = board +"@"+handMask;
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < hand.length(); i++) {
      if (((1<<i)|handMask) == handMask) {
        continue;
      }
      for (int index = 0; index <= board.length(); index++) {
        if ((index > 0 && index < board.length() && board.charAt(index) == board.charAt(index-1) && hand.charAt(i) != board.charAt(index)) || (index < board.length() && hand.charAt(i) == board.charAt(index))) {
          board.insert(index, hand.charAt(i));
          int nextResult = findMinStep(simplify(board), hand, (1<<i)|handMask);
          if (nextResult != Integer.MAX_VALUE) {
            result = Math.min(result, 1+nextResult);
          }
          board.deleteCharAt(index);
        }
      }
    }
    cache.put(key, result);
    return result;
  }
  private StringBuilder simplify(StringBuilder sb) {
    StringBuilder result = new StringBuilder();
    int count = 0;
    for (int i = 0; i < sb.length(); i++) {
      if (i == 0 || sb.charAt(i) == sb.charAt(i-1)) {
        count++;
      } else {
        if (count < 3) {
          while (count-- > 0) {
            result.append(sb.charAt(i-1));
          }
        }
        count = 1;
      }
    }
    if (count < 3) {
      while (count-- > 0) {
        result.append(sb.charAt(sb.length()-1));
      }
    }
    if (result.length() == sb.length()) {
      return result;
    } else {
      return simplify(result);
    }
  }
}
