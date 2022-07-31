package darren.gong.leetcode;

import java.util.Stack;

public class NumSubarrayBoundedMax_795 {
  public static void main(String[] args) {
    NumSubarrayBoundedMax_795 numSubarrayBoundedMax_795 = new NumSubarrayBoundedMax_795();
    numSubarrayBoundedMax_795.numSubarrayBoundedMax(new int[]{55,36,55,52}, 32, 69);
  }
  // 795. 区间子数组个数
  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    int length = A.length;
    int[] leftSmallLength = new int[length];
    Stack<int[]> stack = new Stack<>();
    for (int i = 0; i < length; i++) {
      int current = A[i];
      while (!stack.isEmpty() && stack.peek()[1] <= current) {
        stack.pop();
      }
      leftSmallLength[i] = stack.isEmpty() ? i : i-stack.peek()[0]-1;
      stack.push(new int[]{i, A[i]});
    }
    int[] rightSmallLength = new int[length];
    stack = new Stack<>();
    for (int i = length-1; i >= 0; i--) {
      int current = A[i];
      while (!stack.isEmpty() && stack.peek()[1] < current) {
        stack.pop();
      }
      rightSmallLength[i] = stack.isEmpty() ? length-i-1 : stack.peek()[0]-i-1;
      stack.push(new int[]{i, A[i]});
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      if (A[i] >= L && A[i] <= R) {
        result += (leftSmallLength[i]+1)*(rightSmallLength[i]+1);
      }
    }
    return result;
  }
  // 所有元素都小于R的子数组的个数-所有元素都小于L-1的子数组的个数
  public int numSubarrayBoundedMax2(int[] A, int L, int R) {
    return count(A, R)-count(A, L-1);
  }
  // A的连续子数组中，所有元素都小于max的子数组的个数
  private int count(int[] A, int max) {
    int result = 0;
    int length = A.length;
    int count = 0;
    for (int i = 0; i < length; i++) {
      count = A[i] <= max ? count+1 : 0;
      result += count;
    }
    return result;
  }
}
