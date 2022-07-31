package darren.gong.leetcode;

public class MaxRotateFunction396 {
  public static void main(String[] args) {
    MaxRotateFunction396 maxRotateFunction396 = new MaxRotateFunction396();
    maxRotateFunction396.maxRotateFunction(new int[]{4,3,2,6});
  }
  public int maxRotateFunction(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int length = A.length;
    int index = length-1;
    int value = 0;
    int sum = 0;
    for (int i = 0; i < length; i++) {
      value += A[i]*i;
      sum += A[i];
    }
    int result = value;
    while (index > 0) {
      value += sum;
      value -= A[index--]*length;
      result = Math.max(result, value);
    }
    return result;
  }
}
