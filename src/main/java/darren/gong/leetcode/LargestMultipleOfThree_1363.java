package darren.gong.leetcode;

import java.util.Arrays;

public class LargestMultipleOfThree_1363 {
  public static void main(String[] args) {
    LargestMultipleOfThree_1363 largestMultipleOfThree_1363 = new LargestMultipleOfThree_1363();
    largestMultipleOfThree_1363.largestMultipleOfThree(new int[]{0,1});
  }
  public String largestMultipleOfThree(int[] digits) {
    Arrays.sort(digits);
    int length = digits.length;
    String[] result = new String[3];
    result[0] = "";
    result[1] = "";
    result[2] = "";
    for (int i = 0; i < length; i++) {
      String[] next = new String[3];
      for (int j = 0; j < 3; j++) {
        next[j] = result[j];
      }
      for (int preMod = 0; preMod < 3; preMod++) {
        if (preMod > 0 && result[preMod].length() == 0) {
          continue;
        }
        int mod = (preMod+digits[i])%3;
        if (bigger(result[preMod], digits[i], next[mod])) {
          next[mod] = result[preMod]+digits[i];
        }
      }
      result = next;
    }
    StringBuilder sb = new StringBuilder(result[0]).reverse();
    return (sb.length() > 0 && sb.charAt(0) == '0') ? "0" : sb.toString();
  }
  private boolean bigger(String current, int append, String pre) {
    int preLength = pre.length();
    int currentLength = current.length();
    if (currentLength+1 > preLength) {
      return true;
    } else if (currentLength+1 < preLength) {
      return false;
    } else {
      if (append != pre.charAt(preLength-1)-'a') {
        return append > pre.charAt(preLength-1)-'a';
      }
      for (int i = currentLength; i >= 0; i--) {
        if (current.charAt(i) != pre.charAt(i)) {
          return current.charAt(i) > pre.charAt(i);
        }
      }
      return false;
    }
  }
}
