package darren.gong.leetcode;

public class BeautifulArray_923 {
  private int[][] map;
  public int[] beautifulArray(int n) {
    map = new int[n+1][];
    return beautifulArrayHelper(n);
  }
  private int[] beautifulArrayHelper(int n) {
    if (n == 1) {
      return new int[]{1};
    }
    if (map[n] != null) {
      return map[n];
    }
    int[] result = new int[n];
    int index = 0;
    for (int val : beautifulArrayHelper((n+1)/2)) {
      result[index++] = val*2-1;
    }
    for (int val : beautifulArrayHelper(n/2)) {
      result[index++] = val*2;
    }
    map[n] = result;
    return result;
  }
}
