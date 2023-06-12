package darren.gong.leetcode.race;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSum {
  public static void main(String[] args) {
    KSum kSum = new KSum();
    kSum.kSum(new int[]{2,4,-2}, 5);
  }
  public long kSum(int[] nums, int k) {
    int length = nums.length;
    long sum = 0;
    for (int i = 0; i < length; i++) {
      if (nums[i] > 0) {
        sum += nums[i];
      } else {
        nums[i] = -nums[i];
      }
    }
    Arrays.sort(nums);

    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>((a,b)-> a[0]-b[0] > 0 ? 1 : -1);
    priorityQueue.add(new long[]{nums[0], 0});
    long result = sum;
    while (--k > 0) {
      long[] min = priorityQueue.poll();
      result = sum-min[0];
      if (min[1]+1 < length) {
        priorityQueue.add(new long[]{min[0]-nums[(int) min[1]]+nums[(int) (min[1]+1)], min[1]+1});
        priorityQueue.add(new long[]{min[0]+nums[(int) (min[1]+1)], min[1]+1});
      }
    }
    return result;
  }
}
