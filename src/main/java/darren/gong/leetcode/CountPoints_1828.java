package darren.gong.leetcode;

public class CountPoints_1828 {
  public int[] countPoints(int[][] points, int[][] queries) {
    int length = queries.length;
    int[] result = new int[length];
    int index = 0;
    for (int[] round : queries) {
      for (int[] point : points) {
        if ((point[0]-round[0])*(point[0]-round[0])+(point[1]-round[1])*(point[1]-round[1]) <= round[2]*round[2]) {
          result[index]++;
        }
      }
      index++;
    }
    return result;
  }
}
