package darren.gong.leetcode;

public class CountNumbersWithUniqueDigits_357 {
  public static void main(String[] args) {
    CountNumbersWithUniqueDigits_357 countNumbersWithUniqueDigits_357 = new CountNumbersWithUniqueDigits_357();
    countNumbersWithUniqueDigits_357.countNumbersWithUniqueDigits(2);
  }
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) {
      return 1;
    }
    int result = 10;
    // i位数有多少
    for (int i = 2; i <= n && i <= 10; i++) {
      int tempResult = 9;
      // A 9 i-1
      int current = 9;
      int index = 1;
      while (index < i) {
        tempResult *= current;
        current--;
        index++;
      }
      result += tempResult;
    }
    return result;
  }
}
