package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        long[] temp = new long[]{Long.MIN_VALUE, Long.MIN_VALUE};
        List<String> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp[0] == Long.MIN_VALUE) {
                temp[0] = nums[i];
            } else if (temp[1] == Long.MIN_VALUE) {
                if (temp[0] == nums[i]-1) {
                    temp[1] = nums[i];
                } else {
                    result.add(""+temp[0]);
                    temp[0] = nums[i];
                }
            } else if (temp[1] == nums[i]-1) {
                temp[1] = nums[i];
            } else {
                result.add(""+temp[0]+"->"+temp[1]);
                temp = new long[]{Long.MIN_VALUE, Long.MIN_VALUE};
                temp[0] = nums[i];
            }
        }
        if (temp[1] == Long.MIN_VALUE) {
            result.add(""+temp[0]);
        } else {
            result.add(""+temp[0]+"->"+temp[1]);
        }
        return result;
    }
}
