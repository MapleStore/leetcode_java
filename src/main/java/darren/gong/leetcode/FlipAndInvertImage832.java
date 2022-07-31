package darren.gong.leetcode;

public class FlipAndInvertImage832 {
  public int[][] flipAndInvertImage(int[][] A) {
    if (A == null || A.length == 0 || A[0].length == 0) {
      return A;
    }
    int maxX = A.length;
    for (int i = 0; i < maxX; i++) {
      reverse(A[i]);
    }
    return A;
  }
  private void reverse(int[] arr) {
    int left = 0;
    int right = arr.length-1;
    while (left < right) {
      int temp = arr[left];
      arr[left++] = 1-arr[right];
      arr[right--] = 1-temp;
    }
    if (left == right) {
      arr[left] = 1-arr[left];
    }
    return;
  }
}
