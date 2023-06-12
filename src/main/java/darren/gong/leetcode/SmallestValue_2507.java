package darren.gong.leetcode;

public class SmallestValue_2507 {
  public int smallestValue(int n) {
    for (int result = smallestValueHelper(n); result != n; result = smallestValueHelper(n)) {
      n = result;
    }
    return n;
  }
  public int smallestValueHelper(int n) {
    int result = 0;
    for (int i = 2; i < Math.sqrt(n); i++) {
      while (n%i == 0) {
        result += i;
        n /= i;
      }
    }
    result += n == 1 ? 0 : n;
    return result;
  }

}
