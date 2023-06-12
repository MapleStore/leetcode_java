package darren.gong.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MaximumsSplicedArray_2321 {
  public int maximumsSplicedArray(int[] nums1, int[] nums2) {
    return Math.max(maxReplace(nums1, nums2), maxReplace(nums2, nums1));
  }
  private int maxReplace(int[] nums1, int[] nums2) {
    int length = nums1.length;
    int[] distance = new int[length];
    for (int i = 0; i < length; i++) {
      distance[i] = nums1[i]-nums2[i];
    }
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(0);
    int sum = 0;
    int result = 0;
    for (int i = 0; i < length; i++) {
      sum += distance[i];
      result = Math.max(result, sum-priorityQueue.peek());
      priorityQueue.add(sum);
    }
    return Arrays.stream(nums2).sum()+result;
  }
}
