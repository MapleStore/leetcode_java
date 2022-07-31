package darren.gong.leetcode;

public class NumOfSubarrays_1343 {
  // 1343. 大小为 K 且平均值大于等于阈值的子数组数目
  public static void main(String[] args) {
    NumOfSubarrays_1343 numOfSubarrays_1343 = new NumOfSubarrays_1343();
    numOfSubarrays_1343.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4);
  }
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int length = arr.length;
    int left = 0;
    int right = 0;
    int sum = 0;
    int result = 0;
    while (right < length) {
      sum += arr[right];
      if (left+k-1 == right && threshold*k <= sum) {
        result++;
      }
      if (left+k-1 == right) {
        sum -= arr[left];
        left++;
      }
      right++;
    }
    return result;
  }
}
