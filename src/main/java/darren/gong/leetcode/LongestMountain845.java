package darren.gong.leetcode;

public class LongestMountain845 {
  public int longestMountain(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int length = arr.length;
    int result = 0;
    int[] mountains = new int[length];
    for (int i = 1; i < length; i++) {
      if (arr[i] > arr[i-1]) {
        mountains[i] = mountains[i-1]+1;
      }
    }
    int[] mountainsReverse = new int[length];
    for (int i = length-2; i >= 0; i--) {
      if (arr[i] > arr[i+1]) {
        mountainsReverse[i] = mountainsReverse[i+1]+1;
      }
    }
    for (int i = 1; i < length; i++) {
      if (mountains[i] != 0 && mountainsReverse[i] != 0) {
        result = Math.max(result, mountains[i]+mountainsReverse[i]+1);
      }
    }
    return result;
  }
}
