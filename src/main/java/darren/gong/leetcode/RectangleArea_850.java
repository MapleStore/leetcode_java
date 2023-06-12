package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class RectangleArea_850 {
  public int rectangleArea(int[][] rectangles) {
    int[][] lines = new int[2*rectangles.length][];
    int lineIndex = 0;
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int[] rectangle : rectangles) {
      treeSet.add(rectangle[1]);
      treeSet.add(rectangle[3]);

      lines[lineIndex++] = new int[]{rectangle[0], rectangle[1], rectangle[3], 1};
      lines[lineIndex++] = new int[]{rectangle[2], rectangle[1], rectangle[3], -1};
    }
    int ySize = treeSet.size();
    int[] indexToY = new int[ySize];
    int yIndex = 0;
    Map<Integer, Integer> yToIndex = new HashMap<>();
    for (int y : treeSet) {
      indexToY[yIndex] = y;
      yToIndex.put(y, yIndex);
      yIndex++;
    }

    long result = 0;
    int[] yCount = new int[ySize];
    Arrays.sort(lines, (a,b)->a[0]-b[0]);
    for (int i = 0; i < lines.length; i++) {
      int[] line = lines[i];
      if (i != 0) {
        // count size
        long x = line[0]-lines[i-1][0];
        long yDistance = 0;
        for (int y = 1; y < ySize; y++) {
          if (yCount[y] > 0) {
            yDistance += indexToY[y]-indexToY[y-1];
          }
        }
        result += x*yDistance;
      }


      for (int y = yToIndex.get(line[1])+1; y <= yToIndex.get(line[2]); y++) {
        yCount[y] += line[3];
      }
    }
    return (int)(result%1000000007);
  }
}
