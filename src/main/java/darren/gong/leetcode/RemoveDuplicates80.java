package darren.gong.leetcode;

public class RemoveDuplicates80 {
  public static void main(String[] args) {
    RemoveDuplicates80 removeDuplicates80 = new RemoveDuplicates80();
    removeDuplicates80.removeDuplicates(new int[]{1,1,1,2,2,3});
  }
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length <= 2) {
      return nums.length;
    }
    int index = -1;
    int count = 0;
    for (int num : nums) {
      if (index == -1 || num != nums[index]) {
        nums[++index] = num;
        count = 1;
      } else if (count >= 2) {
        continue;
      } else {
        nums[++index] = num;
        count = 2;
      }
    }
    return index+1;
  }
}
