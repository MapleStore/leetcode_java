package darren.gong.leetcode;

public class RotateString796 {
  public boolean rotateString(String A, String B) {
    return A.length() == B.length() && ((A+A).indexOf(B) != -1);
  }
}
