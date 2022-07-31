package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinAreaFreeRect_963 {
  // 963. 最小面积矩形 II
  public static void main(String[] args) {
    MinAreaFreeRect_963 minAreaFreeRect_963 = new MinAreaFreeRect_963();
    minAreaFreeRect_963.minAreaFreeRect(new int[][]{{0,3},{1,2},{3,1},{1,3},{2,1}});
  }
  public double minAreaFreeRect(int[][] points) {
    Map<Long, HashMap<Integer, ArrayList<int[][]>>> map = new HashMap<>();
    int length = points.length;
    for (int i = 0; i < length; i++) {
      int[] pointA = points[i];
      for (int j = i+1; j < length; j++) {
        int[] pointB = points[j];
        long midX = pointA[0]+pointB[0];
        long midY = pointA[1]+pointB[1];
        int distance = (pointA[0]-pointB[0])*(pointA[0]-pointB[0])+(pointA[1]-pointB[1])*(pointA[1]-pointB[1]);
        map.computeIfAbsent((midX<<25)+midY, k->new HashMap<>()).computeIfAbsent(distance, k->new ArrayList<>()).add(new int[][]{pointA, pointB});
      }
    }
    double min = Double.MAX_VALUE;
    for (HashMap<Integer, ArrayList<int[][]>> disToPairs : map.values()) {
      for (ArrayList<int[][]> pairs : disToPairs.values()) {
        for (int i = 0; i < pairs.size(); i++) {
          for (int j = i+1; j < pairs.size(); j++) {
            min = Math.min(min, countSize(pairs.get(i), pairs.get(j)));
          }
        }
      }
    }
    return min == Double.MAX_VALUE ? 0 : min;
  }

  private double countSize(int[][] lineA, int[][] lineB) {
    int[] point = lineA[0];
    int[] anotherA = lineB[0];
    int[] anotherB = lineB[1];
    return Math.sqrt((point[0]-anotherA[0])*(point[0]-anotherA[0])+(point[1]-anotherA[1])*(point[1]-anotherA[1]))*
        Math.sqrt((point[0]-anotherB[0])*(point[0]-anotherB[0])+(point[1]-anotherB[1])*(point[1]-anotherB[1]));
  }
}
