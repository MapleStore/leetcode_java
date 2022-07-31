package darren.gong.leetcode;

import java.util.Arrays;

public class ProductExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int left = 1;
        for (int i = 1; i < result.length; i++) {
            left *= nums[i-1];
            result[i] = left;
        }
        int right = 1;
        for (int i = result.length-2; i >= 0; i-- ) {
            right *= nums[i+1];
            result[i] *= right;
        }
        return result;
    }
}
