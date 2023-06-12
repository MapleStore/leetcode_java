package darren.gong.leetcode;

public class FindKthNumber_668 {
  public int findKthNumber(int m, int n, int k) {
    int left = 1;
    int right = m*n;
    while (left < right) {
      int mid = (left+right)>>1;
      int count = countLessNum(m, n, mid);
      if (count >= k) {
        right = mid;
      } else {
        left = mid+1;
      }
    }
    return right;
  }
  private int countLessNum(int m, int n, int num) {
    int result = 0;
    for (int i = 1; i <= m; i++) {
      result += Math.min(num/i, n);
    }
    return result;
  }
}
