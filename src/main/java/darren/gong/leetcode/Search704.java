package darren.gong.leetcode;

public class Search704 {
  public static void main(String[] args) {
    Search704 search704 = new Search704();
    search704.search(new int[]{-1,0,3,5,9,12}, 4);
  }
  public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length-1;
    while (start <= end) {
      int mid = start+((end-start)>>>1);
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        end = mid-1;
      } else {
        start = mid+1;
      }
    }
    return -1;
  }
}
