package darren.gong.leetcode;

import java.util.Stack;

public class TotalStrength_2281 {
  public static void main(String[] args) {
    TotalStrength_2281 totalStrength_2281 = new TotalStrength_2281();

  }
  private final int MOD = 1000000007;
  public int totalStrength(int[] strength) {
    int length = strength.length;

    long[] leftMulSum = new long[length];
    long[] rightMulSum = new long[length];
    long[] leftSum = new long[length];
    long[] rightSum = new long[length];

    int[] leftMin = new int[length];
    int[] rightMin = new int[length];
    Stack<Integer> leftStack = new Stack<>();
    for (int i = 0; i < length; i++) {
      while (!leftStack.isEmpty() && strength[leftStack.peek()] >= strength[i]) {
        leftStack.pop();
      }
      leftMin[i] = leftStack.isEmpty() ? i : i-leftStack.peek()-1;
      leftStack.add(i);

      leftMulSum[i] = (long) (i+1) * strength[i] + (i == 0 ? 0 : leftMulSum[i-1]);
      leftSum[i] = (long) strength[i] + (i == 0 ? 0 : leftSum[i-1]);
    }
    Stack<Integer> rightStack = new Stack<>();
    for (int i = length-1; i >= 0; i--) {
      while (!rightStack.isEmpty() && strength[rightStack.peek()] > strength[i]) {
        rightStack.pop();
      }
      rightMin[i] = rightStack.isEmpty() ? length-1-i : rightStack.peek()-i-1;
      rightStack.add(i);

      rightMulSum[i] = (long) (length-i) * strength[i] + (i == length-1 ? 0 : rightMulSum[i+1]);
      rightSum[i] = (long) strength[i] + (i == length-1 ? 0 : rightSum[i+1]);
    }

    long result = 0;
    for (int i = 0; i < length; i++) {
      int leftCount = leftMin[i];
      int rightCount = rightMin[i];

      long leftMulSumFrom = i-leftCount-1 >= 0 ? leftMulSum[i-leftCount-1] : 0;
      long leftSumFrom = i-leftCount-1 >= 0 ? leftSum[i-leftCount-1] : 0;
      result += ((leftMulSum[i]-leftMulSumFrom)-(long)(i-leftCount)*(leftSum[i]-leftSumFrom))%MOD*(long)(rightCount+1)%MOD*strength[i];
      result = result % MOD;

      long rightMulSumFrom = i+rightCount+1 < length ? rightMulSum[i+rightCount+1] : 0;
      long rightSumFrom = i+rightCount+1 < length ? rightSum[i+rightCount+1] : 0;
      result += rightCount == 0 ? 0 :
          ((rightMulSum[i+1]-rightMulSumFrom)-(long)(length-1-(i+rightCount))*(rightSum[i+1]-rightSumFrom))%MOD*((long)leftCount+1)%MOD*strength[i];
      result = result % MOD;
    }
    return (int) result;
  }
}
