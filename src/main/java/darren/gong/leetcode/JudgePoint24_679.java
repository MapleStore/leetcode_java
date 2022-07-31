package darren.gong.leetcode;

public class JudgePoint24_679 {
  static final int TARGET = 24;
  static final double EPSILON = 1e-6;

  public boolean judgePoint24(int[] nums) {
    double[] newNums = new double[4];
    for (int i = 0; i < 4; i++) {
      newNums[i] = nums[i];
    }
    return judgePoint24Helper(newNums);
  }

  public boolean judgePoint24Helper(double[] nums) {
    int length = nums.length;
    if (nums.length == 1) {
      return Math.abs(nums[0]-TARGET) <= EPSILON;
    }
    boolean result = false;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (i == j) {
          continue;
        }
        double current = nums[i]+nums[j];
        result |= judgePoint24Helper(generateNextNum(nums, i, j, current));

        current = nums[i]-nums[j];
        result |= judgePoint24Helper(generateNextNum(nums, i, j, current));

        current = nums[i]*nums[j];
        result |= judgePoint24Helper(generateNextNum(nums, i, j, current));

        if (nums[j] != 0) {
          current = nums[i]/nums[j];
          result |= judgePoint24Helper(generateNextNum(nums, i, j, current));
        }
      }
    }
    return result;
  }

  private double[] generateNextNum(double[] nums, int i, int j, double current) {
    int length = nums.length;
    double[] result = new double[length-1];
    int fillIndex = 0;
    for (int index = 0; index < length; index++) {
      if (index == i || index == j) {
        continue;
      }
      result[fillIndex++] = nums[index];
    }
    result[fillIndex] = current;
    return result;
  }
}
