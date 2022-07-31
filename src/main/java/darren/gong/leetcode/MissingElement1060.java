package darren.gong.leetcode;

public class MissingElement1060 {
  public int missingElement(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int length = nums.length;
    int start = nums[0];
    int result = start+k;
    for (int i = 1; i < length; i++) {
      if (nums[i] > result) {
        return result;
      } else {
        result++;
      }
    }
    return result;
  }
}
