package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates442 {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == -1 || nums[index] == index+1) {
                index++;
                continue;
            }
            if (nums[nums[index]-1] == nums[index]) {
                result.add(nums[index]);
                nums[nums[index]-1] = -1;
                nums[index] = -1;
                index++;
                continue;
            }
            int temp = nums[nums[index]-1];
            nums[nums[index]-1] = nums[index];
            nums[index] = temp;
        }
        return result;
    }
}
