package darren.gong.leetcode;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int best = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length-3; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    best = Math.abs(best-target) > Math.abs(sum-target) ? sum : best;
                    k--;
                } else {
                    best = Math.abs(best-target) > Math.abs(sum-target) ? sum : best;
                    j++;
                }
            }
        }
        return best;
    }
}
