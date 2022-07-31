package darren.gong.leetcode;

import java.util.Arrays;

public class WiggleSort280 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        boolean less = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (less) {
                if (nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            } else {
                if (nums[i] < nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            less = !less;
        }
        return;
    }
}
