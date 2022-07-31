package darren.gong.leetcode;

public class CountTriplets_1442 {
  // 1442. 形成两个异或相等数组的三元组数目
  public int countTriplets(int[] arr) {
    int length = arr.length;
    for (int i = 1; i < length; i++) {
      arr[i] = arr[i]^arr[i-1];
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      for (int k = i+1; k < length; k++) {
        int beforeI = i == 0 ? 0 : arr[i-1];
        if (arr[k] == beforeI) {
          result += k-i;
        }
      }
    }
    return result;
  }
}
