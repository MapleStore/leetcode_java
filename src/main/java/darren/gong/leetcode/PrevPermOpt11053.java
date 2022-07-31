package darren.gong.leetcode;

public class PrevPermOpt11053 {
  public int[] prevPermOpt1(int[] arr) {
    int length = arr.length;
    int min = Integer.MAX_VALUE;
    int i;
    for (i = length-1; i >= 0; i--) {
      min = Math.min(min, arr[i]);
      if (min != arr[i]) {
        break;
      }
    }
    if (i == -1) {
      return arr;
    }
    int max = Integer.MIN_VALUE;
    int target = i;
    for (int j = i+1; j < length; j++) {
      if (arr[j] < arr[i] && arr[j] > max) {
        max = arr[j];
        target = j;
      }
    }

    int temp = arr[target];
    arr[target] = arr[i];
    arr[i] = temp;
    return arr;
  }
}
