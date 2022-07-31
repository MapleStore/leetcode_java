package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new LinkedList<>();
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new int[]{i, 0});
        }
        List<List<Integer>> result = new LinkedList<>();
        while (!queue.isEmpty() && k-- > 0) {
            int[] current = queue.poll();
            if (current[1] < nums2.length-1) queue.add(new int[]{current[0], current[1]+1});
            List<Integer> oneResult = new LinkedList<>();
            oneResult.add(nums1[current[0]]);
            oneResult.add(nums2[current[1]]);
            result.add(oneResult);
        }
        return result;
    }
}
