package darren.gong.leetcode;

public class FindTargetSumWays494 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findTargetSumWays(nums, 0, S);
    }
    public int findTargetSumWays(int[] nums, int start, int S) {
        if (start == nums.length) {
            if (S == 0) {
                return 1;
            }
            return 0;
        }
        return findTargetSumWays(nums, start+1, S+nums[start]) +
                findTargetSumWays(nums, start+1, S-nums[start]);
    }
}
