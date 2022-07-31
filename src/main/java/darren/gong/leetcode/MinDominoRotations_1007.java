package darren.gong.leetcode;

public class MinDominoRotations_1007 {
  // 1007. 行相等的最少多米诺旋转
  public static void main(String[] args) {
    MinDominoRotations_1007 minDominoRotations_1007 = new MinDominoRotations_1007();
    minDominoRotations_1007.minDominoRotations(new int[]{1,2,1,1,1,2,2,2}, new int[]{2,1,2,2,2,2,2,2});
  }
  public int minDominoRotations(int[] A, int[] B) {
    int length = A.length;
    int[] num = new int[7];

    for (int i = 0; i < length; i++) {
      num[A[i]]++;
      if (B[i] != A[i]) {
        num[B[i]]++;
      }
    }
    int result = Integer.MAX_VALUE;
    for (int i = 1; i < 7; i++) {
      if (num[i] != length) {
        continue;
      }
      int count = 0;
      for (int j = 0; j < length; j++) {
        if (A[j] == i) {
          count++;
        }
      }
      result = Math.min(result, Math.min(count, length-count));
      count = 0;
      for (int j = 0; j < length; j++) {
        if (B[j] == i) {
          count++;
        }
      }
      result = Math.min(result, Math.min(count, length-count));
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
