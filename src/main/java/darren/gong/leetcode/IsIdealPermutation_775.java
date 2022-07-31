package darren.gong.leetcode;

public class IsIdealPermutation_775 {
  // 775. 全局倒置与局部倒置
  public static void main(String[] args) {
    IsIdealPermutation_775 isIdealPermutation_775 = new IsIdealPermutation_775();
    isIdealPermutation_775.isIdealPermutation(new int[]{1,0,2});
  }
  private int allCount = 0;
  public boolean isIdealPermutation(int[] nums) {
    int length = nums.length;
    int rangeCount = 0;
    for (int i = 0; i < length-1; i++) {
      if (nums[i] > nums[i+1]) {
        rangeCount++;
      }
    }
    mergeSort(nums, 0, length-1);
    return allCount == rangeCount;
  }
  private void mergeSort(int[] source, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = left+((right-left)>>>1);
    mergeSort(source, left, mid);
    mergeSort(source, mid+1, right);

    int[] result = new int[right-left+1];
    int resultIndex = 0;
    int index1 = left;
    int index2 = mid+1;
    while (index1 <= mid || index2 <= right) {
      int leftValue = index1 > mid ? Integer.MAX_VALUE : source[index1];
      int rightValue = index2 > right ? Integer.MAX_VALUE : source[index2];
      if (leftValue < rightValue) {
        result[resultIndex++] = leftValue;
        index1++;
      } else {
        result[resultIndex++] = rightValue;
        allCount += mid+1-index1;
        index2++;
      }
    }
    resultIndex = 0;
    for (int i = left; i <= right; i++) {
      source[i] = result[resultIndex++];
    }
  }
}
