package darren.gong.leetcode.race;

public class LargestPalindromic {
  public String largestPalindromic(String num) {
    char[] chars = num.toCharArray();
    int[] counts = new int[10];
    for (char oneChar : chars) {
      counts[oneChar-'0']++;
    }
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for (int i = 9; i >= 0; i--) {
      if (i == 0) {
        if (sb1.length() == 0) {
          break;
        }
      }
      int add = counts[i]/2;
      counts[i] %= 2;
      while (add-- > 0) {
        sb1.append(i);
        sb2.append(i);
      }
    }
    for (int i = 9; i >= 0; i--) {
      if (counts[i] >= 1) {
        sb1.append(i);
        break;
      }
    }
    sb1.append(sb2.reverse());
    return sb1.toString();
  }
}
