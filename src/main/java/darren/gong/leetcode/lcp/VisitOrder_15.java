package darren.gong.leetcode.lcp;

public class VisitOrder_15 {
  boolean[] visited;
  int length;
  int[][] points;
  public int[] visitOrder(int[][] points, String direction) {
    this.length = points.length;
    this.points = points;
    this.visited = new boolean[length];
    int[] result = new int[length];
    int resultIndex = 0;
    int currentIndex = 0;
    for (int i = 0; i < length; i++) {
      if (points[i][0] < points[currentIndex][0]) {
        currentIndex = i;
      }
    }
    result[resultIndex++] = currentIndex;
    visited[currentIndex] = true;
    for (int i = 0; i < direction.length(); i++) {
      char oneDir = direction.charAt(i);
      currentIndex = oneDir == 'L' ? findRight(currentIndex) : findLeft(currentIndex);
      result[resultIndex++] = currentIndex;
      visited[currentIndex] = true;
    }
    for (int i = 0; i < length; i++) {
      if (!visited[i]) {
        result[resultIndex++] = i;
      }
    }
    return result;
  }
  private int findLeft(int currentIndex) {
    int[] currentPoint = points[currentIndex];
    int nextIndex = -1;
    for (int i = 0; i < length; i++) {
      if (visited[i]) {
        continue;
      }
      if (nextIndex == -1) {
        nextIndex = i;
        continue;
      }
      int[] lineToNext = new int[]{points[nextIndex][0]-currentPoint[0], points[nextIndex][1]-currentPoint[1]};
      int[] lineToI = new int[]{points[i][0]-currentPoint[0], points[i][1]-currentPoint[1]};
      if (lineToNext[0]*lineToI[1] > lineToNext[1]*lineToI[0]) {
        nextIndex = i;
      }
    }
    return nextIndex;
  }
  private int findRight(int currentIndex) {
    int[] currentPoint = points[currentIndex];
    int nextIndex = -1;
    for (int i = 0; i < length; i++) {
      if (visited[i]) {
        continue;
      }
      if (nextIndex == -1) {
        nextIndex = i;
        continue;
      }
      int[] lineToNext = new int[]{points[nextIndex][0]-currentPoint[0], points[nextIndex][1]-currentPoint[1]};
      int[] lineToI = new int[]{points[i][0]-currentPoint[0], points[i][1]-currentPoint[1]};
      if (lineToNext[0]*lineToI[1] < lineToNext[1]*lineToI[0]) {
        nextIndex = i;
      }
    }
    return nextIndex;
  }
}
