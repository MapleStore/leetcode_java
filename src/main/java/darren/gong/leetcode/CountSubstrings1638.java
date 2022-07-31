package darren.gong.leetcode;

public class CountSubstrings1638 {
  public static void main(String[] args) {
    CountSubstrings1638 countSubstrings1638 = new CountSubstrings1638();
    countSubstrings1638.countSubstrings("bab", "bbb");
  }
  public int countSubstrings(String s, String t) {
    int sLength = s.length();
    int tLength = t.length();
    int result = 0;
    for (int i = 0; i < sLength; i++) {
      for (int j = 0; j < tLength; j++) {
        if (s.charAt(i) == t.charAt(j)) {
          continue;
        }
        int left = 1;
        while (i-left >= 0 && j-left >= 0 && s.charAt(i-left) == t.charAt(j-left)) {
          left++;
        }
        int right = 1;
        while (i+right < sLength && j+right < tLength && s.charAt(i+right) == t.charAt(j+right)) {
          right++;
        }
        result += right*left;
      }
    }
    return result;
  }
}
