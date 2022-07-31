package darren.gong.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarray862 {
  public int shortestSubarray(int[] A, int K) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int length = A.length;
    for (int i = 1; i < length; i++) {
      A[i] += A[i-1];
    }
    int result = Integer.MAX_VALUE;
    Deque<int[]> deque = new ArrayDeque<>();
    for (int i = 0; i < length; i++) {
      while (!deque.isEmpty() && deque.peekLast()[1] > A[i]) {
        deque.pollLast();
      }
      while (!deque.isEmpty() && A[i] - deque.peekFirst()[1] >= K) {
        int[] pre = deque.pollFirst();
        result = Math.min(result, i-pre[0]);
      }
      if (A[i] >= K) {
        result = Math.min(result, i+1);
      }
      deque.addLast(new int[]{i, A[i]});
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
