package darren.gong.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MaxNumber_321 {
  public static void main(String[] args) {
    MaxNumber_321 maxNumber_321 = new MaxNumber_321();
    maxNumber_321.maxNumber(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5);
  }
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int deleteCount = nums1.length+nums2.length-k;
    int max = Math.min(deleteCount, nums1.length);
    int min = Math.max(0, deleteCount-nums2.length);
    int[] result = new int[k];
    for (int i = min; i <= max; i++) {
      int[] final1 = getMaxNums(nums1, i);
      int[] final2 = getMaxNums(nums2, deleteCount-i);
      int[] temp = maxMerge(final1, final2);
      if (bigger(temp, result, 0, 0)) {
        result = temp;
      }
    }
    return result;
  }
  private int[] getMaxNums(int[] nums, int deleteCount) {
    Deque<Integer> deque = new LinkedList<>();
    for (int num : nums) {
      while (!deque.isEmpty() && deque.peekLast() < num && deleteCount > 0) {
        deque.pollLast();
        deleteCount--;
      }
      deque.addLast(num);
    }
    while (deleteCount-- > 0) {
      deque.pollLast();
    }
    int[] result = new int[deque.size()];
    while (!deque.isEmpty()) {
      result[deque.size()-1] = deque.pollLast();
    }
    return result;
  }
  private int[] maxMerge(int[] nums1, int[] nums2) {
    int length1 = nums1.length;
    int length2 = nums2.length;
    int length = length1+length2;
    int index1 = 0;
    int index2 = 0;
    int[] result = new int[length1+length2];
    int index = 0;
    while (index < length) {
      if (index2 >= length2 || (index1 < length1 && nums1[index1] > nums2[index2])) {
        result[index++] = nums1[index1++];
      } else if (index1 >= length1 || nums2[index2] > nums1[index1]) {
        result[index++] = nums2[index2++];
      } else {
        if (bigger(nums1, nums2, index1, index2)) {
          result[index++] = nums1[index1++];
        } else {
          result[index++] = nums2[index2++];
        }
      }
    }
    return result;
  }
  private boolean bigger(int[] nums1, int[] nums2, int index1, int index2) {
    while (index1 < nums1.length && index2 < nums2.length) {
      if (nums1[index1] > nums2[index2]) {
        return true;
      } else if (nums1[index1] < nums2[index2]) {
        return false;
      }
      index1++;
      index2++;
    }
    return nums1.length > index1;
  }
}
