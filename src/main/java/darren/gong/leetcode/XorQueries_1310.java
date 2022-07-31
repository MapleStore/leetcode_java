package darren.gong.leetcode;

public class XorQueries_1310 {
  // 1310. 子数组异或查询
  public int[] xorQueries(int[] arr, int[][] queries) {
    int length = arr.length;
    for (int i = 1; i < length; i++) {
      arr[i] = arr[i]^arr[i-1];
    }
    length = queries.length;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      int[] query = queries[i];
      result[i] = query[0] == 0 ? arr[query[1]] : arr[query[1]]^arr[query[0]-1];
    }
    return result;
  }
}
