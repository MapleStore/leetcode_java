package darren.gong.leetcode.race;

public class CountGoodRectangles {
  public int countGoodRectangles(int[][] rectangles) {
    if (rectangles == null || rectangles.length == 0 || rectangles[0] == null || rectangles[0].length == 0) {
      return 0;
    }
    int length = rectangles.length;
    int[] min = new int[length];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      min[i] = Math.min(rectangles[i][0], rectangles[i][1]);
      max = Math.max(min[i], max);
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      if (min[i] == max) {
        result++;
      }
    }
    return result;
  }
}
