package darren.gong.leetcode;

import java.util.*;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int resultIndex = 0;
        List<Integer> resultList = new ArrayList();
        for (int num : nums2) {
            int times = map.getOrDefault(num, 0);
            if (times > 0) {
                resultList.add(num);
                map.put(num, times-1);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i : resultList) {
            result[resultIndex++] = i;
        }
        return result;
    }
}
