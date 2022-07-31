package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        int result = 0;
        map.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
