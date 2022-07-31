package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IsPossible_659 {
  // 659. 分割数组为连续子序列
  public static void main(String[] args) {
    IsPossible_659 isPossible_659 = new IsPossible_659();
    isPossible_659.isPossible(new int[]{1,2,3,4,6,7,8,9,10,11});
  }
  public boolean isPossible(int[] nums) {
    int length = nums.length;
    int min = nums[0];
    int max = nums[length-1];
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int num : nums) {
      PriorityQueue<Integer> oldPriorityQueue = map.getOrDefault(num-1-min, new PriorityQueue<>());
      int currentLength = oldPriorityQueue.isEmpty() ? 0 : oldPriorityQueue.poll();
      PriorityQueue<Integer> newPriorityQueue = map.get(num-min);
      if (newPriorityQueue == null) {
        newPriorityQueue = new PriorityQueue<>();
        map.put(num-min, newPriorityQueue);
      }
      newPriorityQueue.add(currentLength+1);
    }
    for (PriorityQueue<Integer> queue : map.values()) {
      if (!queue.isEmpty() && queue.peek() < 3) {
        return false;
      }
    }
    return true;
  }
}
