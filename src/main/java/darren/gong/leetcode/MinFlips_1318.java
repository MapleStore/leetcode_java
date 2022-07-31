package darren.gong.leetcode;

public class MinFlips_1318 {
  public static void main(String[] args) {
    MinFlips_1318 minFlips_1318 = new MinFlips_1318();
    minFlips_1318.minFlips(2, 6, 5);
  }
  // 1318. 或运算的最小翻转次数
  public int minFlips(int a, int b, int c) {
    int or = a|b;
    int and = a&b;
    int result = 0;
    for (int i = 0; i < 32; i++) {
      int currentOr = (or<<(31-i))>>>31;
      int currentAnd = (and<<(31-i))>>>31;
      int target = (c<<(31-i))>>>31;
      if (currentOr == target) {
        continue;
      }
      result++;
      if (currentOr == 1 && currentAnd == 1) {
        result++;
      }
    }
    return result;
  }
}
