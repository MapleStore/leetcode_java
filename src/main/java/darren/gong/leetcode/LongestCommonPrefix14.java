package darren.gong.leetcode;

public class LongestCommonPrefix14 {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1 || strs[0].isEmpty()) {
      return strs[0];
    }
    int compareIndex = strs[0].length()-1;
    for (int i = 1; i < strs.length; i++) {
      compareIndex = Math.min(compareIndex, strs[i].length()-1);
      for (int j = 0; j <= compareIndex; j++) {
        if (strs[0].charAt(j) != strs[i].charAt(j)) {
          compareIndex = j-1;
          break;
        }
      }
    }
    return strs[0].substring(0, compareIndex+1);
  }
}

