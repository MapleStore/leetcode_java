package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class MinMoves_1703 {
  public static void main(String[] args) {
    MinMoves_1703 minMoves_1703 = new MinMoves_1703();
    minMoves_1703.minMoves(new int[]{1,0,0,1,0,1,1,1,0,1,1}, 7);
  }
  // 转换为问题：左边把k/2个1移到i位置需要移动多少次, 右边把k/2个1移动到i位置需要移动多少次
  public int minMoves(int[] nums, int k) {
    if (k <= 1) {
      return 0;
    }
    int length = nums.length;
    int[] prefix = new int[length];
    Arrays.fill(prefix, Integer.MAX_VALUE);
    int[] postfix = new int[length];
    Arrays.fill(postfix, Integer.MAX_VALUE);
    int target = k/2;
    int val = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      val += queue.size();
      if (nums[i] == 1) {
        queue.add(i);
      }
      if (queue.size() > target) {
        val -= i-queue.poll();
      }
      if (queue.size() == target) {
        prefix[i] = val;
      }
    }
    val = 0;
    queue = new LinkedList<>();
    for (int i = length-1; i >= 0; i--) {
      val += queue.size();
      if (nums[i] == 1) {
        queue.add(i);
      }
      if (queue.size() > target) {
        val -= queue.poll()-i;
      }
      if (queue.size() == target) {
        postfix[i] = val;
      }
    }
    long result = Integer.MAX_VALUE;
    if (target*2 == k) {
      for (int i = 0; i < length-1; i++) {
        result = Math.min(result, (long)prefix[i]+(long)postfix[i+1]-(long) (0+target-1)*target/2*2);
      }
      return (int) result;
    }
    for (int i = 1; i < length-1; i++) {
      if (nums[i] == 1) {
        result = Math.min(result, (long)prefix[i-1]+(long)postfix[i+1]-(long) (0+target-1)*target/2*2);
      }
    }
    return (int) result;
  }
}
