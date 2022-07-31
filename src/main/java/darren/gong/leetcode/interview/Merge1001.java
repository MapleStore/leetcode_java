package darren.gong.leetcode.interview;

public class Merge1001 {
  public void merge(int[] A, int m, int[] B, int n) {
    int indexA = m-1;
    int indexB = n-1;
    int fillIndex = A.length-1;
    while (fillIndex >= 0) {
      int value;
      if (indexA < 0) {
        value = B[indexB--];
      } else if (indexB < 0) {
        value = A[indexA--];
      } else {
        value = A[indexA] > B[indexB] ? A[indexA--] : B[indexB--];
      }
      A[fillIndex] = value;
      fillIndex--;
    }
  }
}
