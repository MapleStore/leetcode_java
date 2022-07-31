package darren.gong.leetcode;

public class ShortestToChar821 {
  public int[] shortestToChar(String S, char C) {
    if (S == null || S.length() == 0) {
      return new int[0];
    }
    char[] chars = S.toCharArray();
    int length = chars.length;
    int[] left = new int[length];
    left[0] = chars[0] == C ? 0 : 99999;
    for (int i = 1; i < length; i++) {
      left[i] = chars[i] == C ? 0 : left[i-1]+1;
    }
    int[] right = new int[length];
    right[length-1] = chars[length-1] == C ? 0 : 99999;
    for (int i = length-2; i >= 0; i--) {
      right[i] = chars[i] == C ? 0 : right[i+1]+1;
    }
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = Math.min(left[i], right[i]);
    }
    return result;
  }
}
