package darren.gong.leetcode;

import java.util.Arrays;

public class AddNegabinary_1073 {
  // 1073. 负二进制数相加
  public int[] addNegabinary(int[] arr1, int[] arr2) {
    int length1 = arr1.length;
    int length2 = arr2.length;
    int[] result = new int[Math.max(length1, length2)+2];
    int index1 = length1-1;
    int index2 = length2-1;
    int increase = 0;
    int resultIndex = result.length-1;
    while (index1 >= 0 || index2 >= 0 || increase != 0) {
      int one = index1 >= 0 ? arr1[index1--] : 0;
      int two = index2 >= 0 ? arr2[index2--] : 0;
      int tempResult = one+two+increase;
      if (tempResult >= 2) {
        tempResult = tempResult-2;
        increase = -1;
      } else if (tempResult < 0) {
        tempResult = 1;
        increase = 1;
      } else {
        increase = 0;
      }
      result[resultIndex--] = tempResult;
    }
    resultIndex = 0;
    while (resultIndex < result.length && result[resultIndex] == 0) {
      resultIndex++;
    }
    return resultIndex == result.length ? new int[]{0} : Arrays.copyOfRange(result, resultIndex, result.length);
  }
}
