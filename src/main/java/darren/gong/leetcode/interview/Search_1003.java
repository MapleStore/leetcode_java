package darren.gong.leetcode.interview;

public class Search_1003 {
  public static void main(String[] args) {
    Search_1003 search_1003 = new Search_1003();
    search_1003.search(new int[]{2,1,2,2,2}, 99);
  }
  public int search(int[] arr, int target) {
    int minIndex = findMinIndex(arr);
    int result = searchHelper(arr, 0, minIndex-1, target);
    if (result != -1) {
      return result;
    }
    return searchHelper(arr, minIndex, arr.length-1, target);
  }

  private int findMinIndex(int[] arr) {
    int left = 0;
    int right = arr.length-1;

    while (left != right && arr[left] == arr[right]) {
      left++;
    }
    while (left < right) {
      int mid = ((right-left)>>>1)+left;
      int value = arr[mid];
      if (value == arr[right]) {
        right--;
      } else if (value < arr[right]) {
        right = mid;
      } else {
        left = mid+1;
      }
    }
    return left;
  }
  public int searchHelper(int[] arr, int left, int right, int target) {
    if (left > right) {
      return -1;
    }
    while (left <= right) {
      int mid = ((right-left)>>>1)+left;
      int value = arr[mid];
      if (value >= target) {
        right = mid-1;
      } else {
        left = mid+1;
      }
    }
    if (right+1 >= arr.length) {
      return -1;
    }
    return target == arr[right+1] ? right+1 : -1;
  }

}
