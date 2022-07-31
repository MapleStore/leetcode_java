package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> visited = new HashSet<>();
        for (int num : nums1) {
            visited.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (visited.contains(num)) {
                result.add(num);
            }
        }
        int[] realResult = new int[result.size()];
        int index = 0;
        for (int oneNum : result) {
            realResult[index++] = oneNum;
        }
        return realResult;
    }
}
