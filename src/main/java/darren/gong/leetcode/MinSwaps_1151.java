package darren.gong.leetcode;

public class MinSwaps_1151 {
  // 1151. 最少交换次数来组合所有的 1
  public int minSwaps(int[] data) {
    int num = 0;
    for (int value : data) {
      if (value == 1) {
        num++;
      }
    }

    int left = 0;
    int right = 0;
    int length = data.length;
    int oneNum = 0;
    int result = Integer.MAX_VALUE;
    while (right < length) {
      if (data[right] == 1) {
        oneNum++;
      }
      if (right-left+1 >= num) {
        result = Math.min(result, num-oneNum);
        oneNum -= data[left] == 1 ? 1 : 0;
        left++;
      }
      right++;
    }
    return result;
  }
}
