package darren.gong.leetcode;

public class FindMin154 {
  public static void main(String[] args) {
    FindMin154 findMin154 = new FindMin154();
    findMin154.findMin(new int[]{1,3,5});
  }
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int left = 0;
    int right = nums.length-1;
    while (left < right) {
      int mid = left+((right-left)>>>1);
      int rightValue = nums[right];
      int midValue = nums[mid];
      if (midValue > rightValue) {
        left = mid+1;
      } else if (midValue < rightValue) {
        right = mid;
      } else {
        right--;
      }
    }
    return nums[right];
  }
  public int findMin(int[] nums, int left, int right) {
    if (left > right) {
      return Integer.MAX_VALUE;
    }
    if (left >= right-1) {
      return Math.min(nums[left], nums[right]);
    }
    int result = Integer.MAX_VALUE;
    while (left < right) {
      int mid = left+((right-left)>>>1);
      int leftValue = nums[left];
      int rightValue = nums[right];
      int midValue = nums[mid];
      if (leftValue < midValue && midValue < rightValue) {
        return leftValue;
      } else if (leftValue == midValue || midValue == rightValue) {
        int leftRangeValue = leftValue == midValue ? findMin(nums, left+1, mid-1) : findMin(nums, left, mid);
        int rightRangeValue = rightValue == midValue ? findMin(nums, mid+1, right-1) : findMin(nums, mid, right);
        result = Math.min(Math.min(leftRangeValue, rightRangeValue), midValue);
        break;
      } else if (leftValue == rightValue) {
        result = Math.min(leftValue, findMin(nums, left+1, right-1));
        break;
      } else if (midValue > rightValue) {
        left = mid+1;
        result = nums[mid+1];
      } else {
        right = mid;
        result = midValue;
      }
    }
    return result;
  }
}
