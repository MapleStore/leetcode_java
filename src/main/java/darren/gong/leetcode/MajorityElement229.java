package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElement229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int first = nums[0];
        int second = nums[0];
        int times1 = 0;
        int times2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (first == nums[i]) {
                times1++;
                continue;
            }
            if (second == nums[i]) {
                times2++;
                continue;
            }
            if (times1 == 0) {
                first = nums[i];
                times1 = 1;
                continue;
            }
            if (times2 == 0) {
                second = nums[i];
                times2 = 1;
                continue;
            }
            times1--;
            times2--;
        }
        times1 = 0;
        times2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (first == nums[i]) {
                times1++;
            } else if (second == nums[i]) {
                times2++;
            }
        }
        if (times1 > nums.length/3) {
            result.add(first);
        }
        if (times2 > nums.length/3) {
            result.add(second);
        }
        return result;
    }
}
