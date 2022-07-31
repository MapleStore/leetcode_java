package darren.gong.leetcode;

public class MinimumDeletions_1653 {
  // 1653. 使字符串平衡的最少删除次数
  public int minimumDeletions(String s) {
    int length = s.length();
    char[] chars = s.toCharArray();
    int[] left = new int[length];
    int[] right = new int[length];
    int bNum = 0;
    for (int i = 0; i < length; i++) {
      if (chars[i] == 'b') {
        bNum++;
      }
      left[i] = bNum;
    }
    int aNum = 0;
    for (int i = length-1; i >= 0; i--) {
      if (chars[i] == 'a') {
        aNum++;
      }
      right[i] = aNum;
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < length; i++) {
      int temp = Math.min(left[i]+(i+1 < length ? right[i+1] : 0), right[i]+(i-1 >= 0 ? left[i-1] : 0));
      result = Math.min(result, temp);
    }
    return result;
  }
}
