package darren.gong.leetcode;

public class Search {
    public static void main(String[] args) {
        search(new int[]{4,5,6,7,0,1,2}, 0);
    }
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int result = search(nums, 0, low-1, target);
        if (result !=  -1) {
            return result;
        }
        return search(nums, low, nums.length - 1, target);
    }
    public static int search(int[] nums, int start, int end, int target) {
        int low = start;
        int high = end;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low >= 0 && low < nums.length && nums[low] == target) {
            return low;
        }
        return -1;
    }

}
