package darren.gong.leetcode;

public class MinSubArrayLen209 {
    public static void main(String[] args) {
        MinSubArrayLen209 minSubArrayLen209 = new MinSubArrayLen209();
        minSubArrayLen209.minSubArrayLen(4, new int[]{1,4,4});
    }
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int windowSum = 0;
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int windowLength = 0;
        while (right < nums.length) {
            windowSum += nums[right];
            windowLength++;
            while (windowSum >= s) {
                if (windowSum >= s) {
                    result = Math.min(result, windowLength);
                }
                windowLength--;
                windowSum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
