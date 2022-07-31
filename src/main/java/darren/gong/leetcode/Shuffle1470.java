package darren.gong.leetcode;

public class Shuffle1470 {
  public int[] shuffle(int[] nums, int n) {
    int[] result = new int[2*n];
    int left = 0;
    int right = n;
    int index = 0;
    while (left < n) {
      result[index++] = nums[left++];
      result[index++] = nums[right++];
    }
    return result;
  }
}
