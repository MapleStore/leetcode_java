package darren.gong.leetcode;

public class MinimumSwap_1247 {
  // 1247. 交换字符使得字符串相同
  public int minimumSwap(String s1, String s2) {
    int length = s1.length();
    int s1X = 0;
    int s1Y = 0;
    for (int i = 0; i < length; i++) {
      if (s1.charAt(i) == s2.charAt(i)) {
        continue;
      }
      if (s1.charAt(i) == 'x') {
        s1X++;
      } else {
        s1Y++;
      }
    }
    if ((s1X+s1Y)%2 != 0) {
      return -1;
    }
    return (s1X/2)+(s1Y/2)+(s1X%2)+(s1Y%2);
  }
}
