package darren.gong.leetcode;

public class FindLengthOfShortestSubarray_1574 {
  public static void main(String[] args) {
    FindLengthOfShortestSubarray_1574 findLengthOfShortestSubarray_1574 = new FindLengthOfShortestSubarray_1574();
    findLengthOfShortestSubarray_1574.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5});
  }
  public int findLengthOfShortestSubarray(int[] arr) {
    int length = arr.length;
    boolean[] biggerThanPre = new boolean[length];
    biggerThanPre[0] = true;
    boolean[] smallerThanLate = new boolean[length];
    smallerThanLate[length-1] = true;
    for (int i = 1; i < length; i++) {
      biggerThanPre[i] = arr[i] >= arr[i-1] && biggerThanPre[i-1];
    }
    for (int j = length-2; j >= 0; j--) {
      smallerThanLate[j] = arr[j] <= arr[j+1] && smallerThanLate[j+1];
    }
    int left = 0;
    int right = length-1;
    while (left <= right) {
      int mid = left+((right-left)>>>1);
      if (valid(biggerThanPre, smallerThanLate, arr, mid)) {
        right = mid-1;
      } else {
        left = mid+1;
      }
    }
    return right+1;
  }
  private boolean valid(boolean[] biggerThanPre, boolean[] smallerThanLate, int[] arr, int deleteLen) {
    for (int i = 0; i+deleteLen <= arr.length; i++) {
      boolean leftOrder = i-1 < 0 || biggerThanPre[i-1];
      boolean midOrder = i-1 < 0 || i+deleteLen == arr.length || arr[i-1] <= arr[i+deleteLen];
      boolean rightOrder = i+deleteLen == arr.length || smallerThanLate[i+deleteLen];
      if (leftOrder && midOrder && rightOrder) {
        return true;
      }
    }
    return false;
  }
}
