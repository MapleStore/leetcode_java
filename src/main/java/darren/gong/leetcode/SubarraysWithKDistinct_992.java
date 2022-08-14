package darren.gong.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class SubarraysWithKDistinct_992 {
  public int subarraysWithKDistinct(int[] nums, int k) {
    int length = nums.length;
    int right = 0;
    int left = 0;
    int result = 0;
    Map<Integer, Integer> lastIndex = new HashMap<>();
    TreeSet<Integer> minIndex = new TreeSet<>();
    while (right < length) {
      int val = nums[right];
      Integer preIndex = lastIndex.get(val);
      minIndex.remove(preIndex == null ? -1 : preIndex);
      minIndex.add(right);
      lastIndex.put(val, right);

      if (lastIndex.size() == k) {
        int firstIndex = minIndex.first();
        result += firstIndex-left+1;
      } else if (lastIndex.size() >= k) {
        int firstIndex = minIndex.pollFirst();
        lastIndex.remove(nums[firstIndex]);
        left = firstIndex+1;

        result += minIndex.first()-left+1;
      }
      right++;
    }
    return result;
  }
}
