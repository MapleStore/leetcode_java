package darren.gong.leetcode;

public class MinSteps1347 {
  public int minSteps(String s, String t) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] count = new int[26];
    int length = s.length();
    for (int i = 0; i < length; i++) {
      count[s.charAt(i)-'a']++;
      count[t.charAt(i)-'a']--;
    }
    int result = 0;
    for (int i = 0; i < 26; i++) {
      result += Math.abs(count[i]);
    }
    return result>>>1;
  }
}
