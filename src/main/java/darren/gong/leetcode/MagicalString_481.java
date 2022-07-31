package darren.gong.leetcode;

public class MagicalString_481 {
  public static void main(String[] args) {
    MagicalString_481 magicalString_481 = new MagicalString_481();
    magicalString_481.magicalString(9);
  }
  public int magicalString(int n) {
    if (n == 0) {
      return 0;
    }
    int[] dp = new int[100001];
    dp[0] = 1;
    dp[1] = 2;
    int fillValue = 1;
    int result = 0;
    int currentIndex = 0;
    int fillIndex = 0;
    while (true) {
      int num = dp[currentIndex];
      while (num-- > 0) {
        dp[fillIndex++] = fillValue;
        if (fillValue == 1) {
          result++;
        }
        if (fillIndex == n) {
          return result;
        }
      }
      currentIndex++;
      fillValue = 3-fillValue;
    }
  }
}
