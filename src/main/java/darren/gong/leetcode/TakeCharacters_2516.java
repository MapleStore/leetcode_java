package darren.gong.leetcode;

public class TakeCharacters_2516 {
  public int takeCharacters(String s, int k) {
    if (k == 0) {
      return 0;
    }
    int left = 0;
    int[] counts = new int[3];
    for (; left < s.length(); left++) {
      counts[s.charAt(left)-'a']++;
      if (checkValid(counts, k)) {
        break;
      }
    }
    if (left == s.length()) return -1;
    int result = left+1;
    int right = s.length()-1;
    while (right >= left && left >= 0) {
      counts[s.charAt(right)-'a']++;
      while (left >= 0 && counts[s.charAt(left)-'a'] > k) {
        left--;
        counts[s.charAt(left)-'a']--;
      }
      result = Math.min(result, left+1+s.length()-right);
      right--;
    }
    return result;
  }
  private boolean checkValid(int[] counts, int k) {
    return counts[0] >= k && counts[1] >= k && counts[2] >= k;
  }
}
