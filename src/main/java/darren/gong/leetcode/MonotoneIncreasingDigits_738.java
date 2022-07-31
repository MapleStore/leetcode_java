package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MonotoneIncreasingDigits_738 {
  public static void main(String[] args) {
    MonotoneIncreasingDigits_738 monotoneIncreasingDigits_738 = new MonotoneIncreasingDigits_738();
    monotoneIncreasingDigits_738.monotoneIncreasingDigits(987654);

  }
  public int monotoneIncreasingDigits(int N) {
    char[] arr = String.valueOf(N).toCharArray();
    int length = arr.length;
    int decreaseIndex = -1;
    for (int i = 0; i < length; i++) {
      if (i == 0 || arr[i] >= arr[i-1]) {
        continue;
      }
      decreaseIndex = i;
      while (decreaseIndex > 0 && arr[decreaseIndex]-1 < arr[decreaseIndex-1]) {
        decreaseIndex--;
      }
      break;
    }
    if (decreaseIndex == -1) {
      return N;
    }
    if (decreaseIndex == 0 && arr[decreaseIndex] == '1') {
      char[] result = new char[length-1];
      Arrays.fill(result, '9');
      return Integer.parseInt(new String(result));
    }
    arr[decreaseIndex]--;
    Arrays.fill(arr, decreaseIndex+1, length, '9');
    return Integer.parseInt(new String(arr));
  }
}
