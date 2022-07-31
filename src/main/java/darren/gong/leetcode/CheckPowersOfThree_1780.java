package darren.gong.leetcode;

public class CheckPowersOfThree_1780 {
  // 1780. 判断一个数字是否可以表示成三的幂的和
  public boolean checkPowersOfThree(int n) {
    if (n == 1) {
      return true;
    }
    int num = n % 3;
    if (num == 0 || num == 1) {
      return checkPowersOfThree(n/3);
    }
    return false;
  }
}
