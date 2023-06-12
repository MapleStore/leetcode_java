package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountPartitions_2518 {
  public static void main(String[] args) {
    CountPartitions_2518 countPartitions_2518 = new CountPartitions_2518();
    countPartitions_2518.countPartitions(new int[]{1,2,3,4}, 4);
  }
  public int countPartitions(int[] nums, int k) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
      if (sum >= 2*k) {
        break;
      }
    }
    if (sum < 2*k) {
      return 0;
    }
    long invalidCount = 0;
    for (int need = 0; need < k; need++) {
      invalidCount += count(nums, nums.length-1, need);
      invalidCount %= 1000000007;
    }
    long allCount = 1;
    for (int num : nums) {
      allCount = (allCount<<1);
      allCount %= 1000000007;
    }

    return (int) (allCount-2*invalidCount < 0 ? allCount-2*invalidCount+1000000007 : allCount-2*invalidCount);
  }
  private Map<Integer, Integer> cache = new HashMap<>();
  private int count(int[] nums, int index, int need) {
    if (need < 0) {
      return 0;
    }
    if (need == 0) {
      return 1;
    }
    if (index == 0) {
      return need == nums[0] ? 1 : 0;
    }

    if (cache.containsKey((need<<10)+index)) {
      return cache.get((need<<10)+index);
    }
    long result = count(nums, index-1, need);
    result += count(nums, index-1, need-nums[index]);
    result %= 1000000007;
    cache.put((need<<10)+index, (int)result);
    return (int)result;
  }
}
