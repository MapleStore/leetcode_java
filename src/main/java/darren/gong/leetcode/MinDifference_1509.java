package darren.gong.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinDifference_1509 {
  public int minDifference(int[] nums) {
    int length = nums.length;
    if (length <= 4) {
      return 0;
    }
    PriorityQueue<Integer> big = new PriorityQueue<>((a, b)->b-a);
    PriorityQueue<Integer> small = new PriorityQueue<>();
    for (int num : nums) {
      big.add(num);
      if (big.size() > 4) {
        big.poll();
      }
      small.add(num);
      if (small.size() > 4) {
        small.poll();
      }
    }
    int[] bigResult = new int[4];
    int[] smallResult = new int[4];
    for (int i = 0; i < 4; i++) {
      bigResult[i] = small.poll();
      smallResult[i] = big.poll();
    }
    Arrays.sort(smallResult);
    Arrays.sort(bigResult);
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      int bigVal = bigResult[i];
      int smallVal = smallResult[i];
      result = Math.min(bigVal-smallVal, result);
    }
    return result;
  }
}
