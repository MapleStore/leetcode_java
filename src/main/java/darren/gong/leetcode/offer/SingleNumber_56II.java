package darren.gong.leetcode.offer;

public class SingleNumber_56II {
  // 剑指 Offer 56 - II. 数组中数字出现的次数 II
  public int singleNumber(int[] nums) {
    int[] count = new int[32];
    for (int i = 0; i < 32; i++) {
      for (int num : nums) {
        if ((num & (1<<i)) != 0) {
          count[i]++;
        }
      }
    }
    int result = 0;
    for (int i = 0; i < 32; i++) {
      if (count[i]%3 != 0) {
        result |= (1<<i);
      }
    }
    return result;
  }
}
