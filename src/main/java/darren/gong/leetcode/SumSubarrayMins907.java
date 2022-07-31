package darren.gong.leetcode;

import java.util.Stack;

public class SumSubarrayMins907 {
  public int sumSubarrayMins(int[] arr) {
    Stack<int[]> stack = new Stack<>();
    stack.add(new int[]{-1, -1});
    int length = arr.length;
    long[] result = new long[length];
    long mod = (long)Math.pow(10, 9)+7;
    for (int i = 0; i < length; i++) {
      int[] last;
      while (!stack.isEmpty() && (last = stack.peek())[1] >= arr[i]) {
        result[last[0]] = result[last[0]]*(i-last[0])%mod;
        stack.pop();
      }
      result[i] = arr[i]*(i-stack.peek()[0])%mod;
      stack.push(new int[]{i, arr[i]});
    }

    while (stack.size() > 1) {
      int[] last = stack.pop();
      result[last[0]] = result[last[0]]*(length-last[0]);
    }

    long realResult = 0;
    for (long oneResult : result) {
      realResult = (realResult+oneResult)%mod;
    }
    return (int)realResult;
  }
}
