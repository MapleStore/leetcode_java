package darren.gong.leetcode;

public class GetHappyString1415 {
  private String result;
  private int num = 0;
  private int k;
  public String getHappyString(int n, int k) {
    this.k = k;
    backTracking(n, new StringBuilder());
    return result == null ? "" : result;
  }
  private void backTracking(int end, StringBuilder sb) {
    if (result != null) {
      return;
    }
    if (sb.length() == end) {
      num++;
      if (num == k) {
        result = sb.toString();
      }
      return;
    }

    for (int i = 'a'; i <= 'c'; i++) {
      if (sb.length() == 0 || sb.charAt(sb.length()-1) != i) {
        sb.append((char)i);
        backTracking(end, sb);
        sb.deleteCharAt(sb.length()-1);
      }
    }
  }
}
