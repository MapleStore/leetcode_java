package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate219 {
/*
    [1,0,1,1]
            1
*/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer lastNumIndex = lastIndex.get(nums[i]);
            if (lastNumIndex != null && (i-lastNumIndex <= k)) {
                return true;
            }
            lastIndex.put(nums[i], i);
        }
        return false;
    }
}
