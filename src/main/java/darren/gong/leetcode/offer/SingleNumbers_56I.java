package darren.gong.leetcode.offer;

public class SingleNumbers_56I {
  // 剑指 Offer 56 - I. 数组中数字出现的次数
  public int[] singleNumbers(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    int mask = 1;
    while ((mask & result) == 0) {
      mask = mask<<1;
    }
    int a = 0;
    int b = 0;
    for (int num : nums) {
      if ((num & mask) == 0) {
        a ^= num;
      } else {
        b ^= num;
      }
    }
    return new int[]{a, b};
  }
}
