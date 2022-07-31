package darren.gong.leetcode;

public class Search81 {
    public static void main(String[] args) {
        Search81 search81 = new Search81();
        search81.search(new int[]{1}, 1);
    }
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (nums[mid] == target || target == nums[low] || target == nums[high]) {
                return true;
            } else if (nums[mid] == nums[high] && nums[mid] == nums[low]) {
                high--;
                low++;
            } else if (nums[mid] > nums[high]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
