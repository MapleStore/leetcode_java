package darren.gong.leetcode;

public class SortedSquares977 {
  public int[] sortedSquares(int[] A) {
    if (A == null) {
      return null;
    }
    if (A.length == 0) {
      return new int[0];
    }
    if (A.length == 1) {
      return new int[]{A[0]*A[0]};
    }
    int length = A.length;
    int left = -1;
    int right = length;
    int resultIndex = 0;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      if (A[i] < 0) {
        left = i;
      } else if (A[i] > 0) {
        right = i;
        break;
      }
    }
    while (resultIndex < right-left-1) {
      result[resultIndex++] = 0;
    }
    while (left >= 0 || right < length) {
      int leftValue = left < 0 ? Integer.MAX_VALUE : A[left]*A[left];
      int rightValue = right >= length ? Integer.MAX_VALUE : A[right]*A[right];
      if (leftValue >= rightValue) {
        result[resultIndex++] = rightValue;
        right++;
      } else {
        result[resultIndex++] = leftValue;
        left--;
      }
    }
    return result;
  }
}
