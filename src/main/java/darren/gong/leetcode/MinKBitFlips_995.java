package darren.gong.leetcode;

public class MinKBitFlips_995 {
/*
  贪心部分的证明。

  结论1：最靠左的翻转的左边界一定是第一个0的位置。

  证明：反证，若不然，则最左侧的翻转的左边界要么是1，要么不是第一个0。如果是1的话，那么这个1会变为0且没有操作可以将它变回1。如果不是第一个0的话，那么第一个0也无法变为1。
*/
  public int minKBitFlips(int[] nums, int k) {
    int length = nums.length;
    int[] diff = new int[length+1];
    int result = 0;
    int count = 0;
    for (int i = 0; i < length; i++) {
      count += diff[i];
      if ((nums[i]+count)%2 == 1) {
        continue;
      }
      if (i+k > length) {
        return -1;
      }
      result++;
      count++;
      diff[i+k]--;
    }
    return result;
  }
}
