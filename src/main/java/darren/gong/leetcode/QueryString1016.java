package darren.gong.leetcode;

public class QueryString1016 {
  public boolean queryString(String S, int N) {
    while (N >= 1) {
      if (!S.contains(Integer.toBinaryString(N))) {
        return false;
      }
      N--;
    }
    return true;
  }
}
