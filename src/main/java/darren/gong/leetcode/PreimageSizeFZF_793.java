package darren.gong.leetcode;

public class PreimageSizeFZF_793 {
  public static void main(String[] args) {
    PreimageSizeFZF_793 preimageSizeFZF_793 = new PreimageSizeFZF_793();
    preimageSizeFZF_793.preimageSizeFZF(5);
  }
  public int preimageSizeFZF(int k) {
    if (k == 0) {
      return 5;
    }
    return (int) (maxNumContains5(k)-maxNumContains5(k-1));
  }
  private long maxNumContains5(int k) {
    long right = 5L*(k+1);
    long left = 0;
    while (left < right) {
      long mid = (left+right+1)>>1;
      long count = count5(mid);
      if (count > k) {
        right = mid-1;
      } else {
        left = mid;
      }
    }
    return left;
  }
  private long count5(long num) {
    int result = 0;
    while (num > 0) {
      result += num/5;
      num /= 5;
    }
    return result;
  }
}
