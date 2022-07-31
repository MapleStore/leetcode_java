package darren.gong.leetcode;

import java.util.Arrays;

public class FindSubstringInWraproundString467 {
  public static void main(String[] args) {
    FindSubstringInWraproundString467 findSubstringInWraproundString467 = new FindSubstringInWraproundString467();
    findSubstringInWraproundString467.findSubstringInWraproundString("abd");
  }
  private char pre;
  public int findSubstringInWraproundString(String p) {
    if (p == null || p.length() == 0) {
      return 0;
    }
    int length = p.length();
    int[] maxCount = new int[26];
    int[] start = new int[26];
    Arrays.fill(start, Integer.MAX_VALUE);
    char[] arr = p.toCharArray();
    pre = arr[0];
    start[arr[0]-'a'] = 0;
    for (int i = 1; i < length; i++) {
      if (canAppendPre(arr[i])) {
        start[arr[i]-'a'] = Math.min(start[arr[i]-'a'], i);
        pre = arr[i];
        continue;
      }
      pre = arr[i];
      for (int j = 0; j < 26; j++) {
        maxCount[j] = Math.max(maxCount[j], i-start[j]);
      }
      Arrays.fill(start, Integer.MAX_VALUE);
      start[pre-'a'] = i;
    }

    for (int j = 0; j < 26; j++) {
      maxCount[j] = Math.max(maxCount[j], length-start[j]);
    }

    int result = 0;
    for (int value : maxCount) {
      result += value;
    }
    return result;
  }
  private boolean canAppendPre(char currentChar) {
    return currentChar == pre+1 || (pre == 'z' && currentChar == 'a');
  }
}
