package darren.gong.leetcode;

public class CycleLengthQueries_2509 {
  public int[] cycleLengthQueries(int n, int[][] queries) {
    int length = queries.length;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = count(queries[i][0], queries[i][1]);
    }
    return result;
  }
  private int count(int node1, int node2) {
    if (node1 == node2) {
      return 1;
    }
    return (node1 > node2 ? count(node1>>1, node2) : count(node1, node2>>1))+1;
  }
}
