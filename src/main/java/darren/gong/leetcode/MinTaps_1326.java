package darren.gong.leetcode;

public class MinTaps_1326 {
  public static void main(String[] args) {
    MinTaps_1326 minTaps_1326 = new MinTaps_1326();
    minTaps_1326.minTaps(14, new int[]{1,0,4,0,4,1,4,3,1,1,1,2,1,4,0});
  }
  public int minTaps(int n, int[] ranges) {
    int[] rightIndex = new int[n+1];
    for (int i = 0; i <= n; i++) {
      int left = i-ranges[i];
      int right = i+ranges[i];
      for (int j = Math.max(0, left); j <= Math.min(n, right); j++) {
        rightIndex[j] = Math.max(rightIndex[j], right);
      }
    }
    int result = 0;
    int i = 0;
    while (i < n) {
      if (rightIndex[i] == i) {
        return -1;
      }
      i = rightIndex[i];
      result++;
    }
    return result;
  }
}
