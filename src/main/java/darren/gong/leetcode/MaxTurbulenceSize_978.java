package darren.gong.leetcode;

public class MaxTurbulenceSize_978 {
  // 978. 最长湍流子数组
  public static void main(String[] args) {
    MaxTurbulenceSize_978 maxTurbulenceSize_978 = new MaxTurbulenceSize_978();
    maxTurbulenceSize_978.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9});
  }
  public int maxTurbulenceSize(int[] arr) {
    if (arr.length == 1) {
      return 1;
    }
    int left = 0;
    int right = 0;
    boolean up = arr[right] < arr[right+1];
    int result = Integer.MIN_VALUE;
    while (right < arr.length-1) {
      if ((up && arr[right] < arr[right+1]) || (!up && arr[right] > arr[right+1])) {
        right++;
        up = !up;
        continue;
      }
      result = Math.max(result, right-left+1);
      if (arr[right] == arr[right+1]) {
        right++;
        left = right;
        continue;
      }
      left = right;
      up = arr[right] < arr[right+1];
    }
    result = Math.max(result, right-left+1);
    return result;
  }
}
