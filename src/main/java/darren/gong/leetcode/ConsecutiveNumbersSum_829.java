package darren.gong.leetcode;

public class ConsecutiveNumbersSum_829 {
  public static void main(String[] args) {
    ConsecutiveNumbersSum_829 consecutiveNumbersSum_829 = new ConsecutiveNumbersSum_829();
    consecutiveNumbersSum_829.consecutiveNumbersSum(1);
  }
  public int consecutiveNumbersSum(int n) {
    // 枚举i个数的和 = n
    // 1+...+i = n 是最小的和
    // 1+...+k = (k*k+k)/2 <= n
    int result = 0;
    long limit = (long) Math.sqrt(2*n);
    for (int i = 1; i <= limit; i++) {
      long mid = n/i;
      if (i%2 == 0 && (mid+mid+1)*i/2 == n) {
        result++;
      } else if (i%2 == 1 && mid*i == n) {
        result++;
      }
    }
    return result;
  }
}
