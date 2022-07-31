package darren.gong.leetcode;

public class SearchInsert35 {
  public int searchInsert(int[] nums, int target) {
    if (target > nums[nums.length-1]) {
      return nums.length;
    }
    int start = 0;
    int end = nums.length-1;
    while (start < end) {
      int mid = start+(end-start)/2;
      if (nums[mid] == target) {
        return mid;
      } else if (target > nums[mid]) {
        start = mid+1;
      } else {
        end = mid;
      }
    }
    return start;
  }
}
