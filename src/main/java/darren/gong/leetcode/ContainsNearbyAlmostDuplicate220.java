package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyAlmostDuplicate220 {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    Map<Long, Long> map = new HashMap<>();
    int length = nums.length;
    t = t+1;
    for (int i = 0; i < length; i++) {
      long bucket = getId(nums[i], t);
      if (map.containsKey(bucket)) {
        return true;
      }
      if (map.containsKey(bucket+1) && Math.abs(map.get(bucket+1)-nums[i]) < t) {
        return true;
      }
      if (map.containsKey(bucket-1) && Math.abs(map.get(bucket-1)-nums[i]) < t) {
        return true;
      }
      map.put(bucket, (long)nums[i]);
      if (i >= k) {
        map.remove(getId(nums[i-k], t));
      }
    }
    return false;
  }
  private long getId(long value, long size) {
    return value < 0 ? (value+1)/size-1 : value/size;
  }
}
