package darren.gong.leetcode;

import java.util.PriorityQueue;

public class MedianSlidingWindow480 {
  public static void main(String[] args) {
    MedianSlidingWindow480 medianSlidingWindow480 = new MedianSlidingWindow480();
    medianSlidingWindow480.medianSlidingWindow(new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3);
  }
  public double[] medianSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> big = new PriorityQueue<>();
    PriorityQueue<Integer> small = new PriorityQueue<>((a,b)->{
      if (a > b) {
        return -1;
      } else {
        return 1;
      }
    });
    boolean isDouble = k % 2 == 0;
    int left = 0;
    int right = 0;
    double[] result = new double[nums.length-k+1];
    int resultIndex = 0;
    while (right < nums.length) {
      addNum(big, small, nums[right]);
      if (right-left+1 >= k) {
        if (isDouble) {
          result[resultIndex++] = ((double)big.peek()/2)+((double)small.peek()/2);
        } else {
          result[resultIndex++] = big.peek();
        }
        removeNum(big, small, nums[left]);
        left++;
      }
      right++;
    }
    return result;
  }

  private void removeNum(PriorityQueue<Integer> big, PriorityQueue<Integer> small, int num) {
    if (!small.remove(num)) {
      big.remove(num);
    }
  }
  private void addNum(PriorityQueue<Integer> big, PriorityQueue<Integer> small, int num) {
    if (big.size() <= small.size()) {
      small.add(num);
      big.add(small.poll());
    } else {
      big.add(num);
      small.add(big.poll());
    }
  }
}
