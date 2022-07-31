package darren.gong.leetcode;

public class LongestOnes_1004 {
  // 1004. 最大连续1的个数 III
  public int longestOnes(int[] A, int K) {
    int left = 0;
    int right = 0;
    int count = 0;
    int length = A.length;
    int result = 0;
    while (right < length) {
      if (A[right] == 0) {
        count++;
      }
      if (count <= K) {
        result = Math.max(right-left+1, result);
      }
      while (count > K) {
        if (A[left] == 0) {
          count--;
        }
        left++;
      }
      right++;
    }
    return result;
  }
}
