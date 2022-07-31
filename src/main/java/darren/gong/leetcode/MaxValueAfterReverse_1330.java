package darren.gong.leetcode;

public class MaxValueAfterReverse_1330 {
  public static void main(String[] args) {
    MaxValueAfterReverse_1330 maxValueAfterReverse_1330 = new MaxValueAfterReverse_1330();
    maxValueAfterReverse_1330.maxValueAfterReverse(new int[]{2,3,1,5,4});
  }
  public int maxValueAfterReverse(int[] nums) {
    int base = 0;
    int length = nums.length;
    for (int i = 0; i < nums.length-1; i++) {
      base += Math.abs(nums[i]-nums[i+1]);
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      if (i != length-1) {
        result = Math.max(result, base-Math.abs(nums[i]-nums[i+1])+Math.abs(nums[0]-nums[i+1]));
      }
      if (i != 0) {
        result = Math.max(result, base-Math.abs(nums[i-1]-nums[i])+Math.abs(nums[i-1]-nums[length-1]));
      }
    }
    int[][] directions = new int[][]{{-1,-1, 1,1}, {-1,1, 1,-1}, {1,-1, -1,1}, {1,1, -1,-1}};
    for (int[] direction : directions) {
      int left = Integer.MIN_VALUE>>1;
      int right = Integer.MIN_VALUE>>1;
      for (int i = 1; i < nums.length-1; i++) {
        right = Math.max(direction[2]*nums[i]+direction[3]*nums[i+1]-Math.abs(nums[i]-nums[i+1]), right);
        result = Math.max(result, base+right+left);
        int tempLeft = direction[0]*nums[i-1]+direction[1]*nums[i]-Math.abs(nums[i-1]-nums[i]);
        if (tempLeft > left) {
          left = tempLeft;
          right = Integer.MIN_VALUE>>1;
        }
      }
    }
    return result;
  }
}
