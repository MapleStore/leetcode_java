package darren.gong.leetcode;

public class AddDigits258 {
  public int addDigits(int num) {
    if (num == 0) {
      return 0;
    }
    int result = num%9;
    return result == 0 ? 9 : result;
  }
}
