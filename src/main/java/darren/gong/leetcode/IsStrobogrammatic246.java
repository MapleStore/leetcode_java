package darren.gong.leetcode;

public class IsStrobogrammatic246 {
  private static char[] map = new char[]{'0', '1', '@', '@', '@', '@', '9', '@', '8', '6'};
  public boolean isStrobogrammatic(String num) {
    if (num == null) {
      return false;
    }
    char[] nums = num.toCharArray();
    int length = num.length();
    if (length == 0) {
      return true;
    }
    for (int i = 0; i <= length/2; i++) {
      if (nums[length-1-i] != map[nums[i]-'0']) {
        return false;
      }
    }
    return true;
  }
}
