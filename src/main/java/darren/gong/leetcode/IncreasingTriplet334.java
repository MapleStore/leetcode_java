package darren.gong.leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class IncreasingTriplet334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for (int oneNum : nums) {
            if (oneNum <= min) {
                min = oneNum;
            } else if (oneNum <= secMin){
                secMin = oneNum;
            } else {
                return true;
            }
        }
        return false;
    }
}
