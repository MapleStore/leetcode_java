package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class KClosest973 {
  public static void main(String[] args) {
    KClosest973 kClosest973 = new KClosest973();
    kClosest973.kClosest(new int[][]{{-2,-6},{-7,-2},{-9,6},{10,3},{-8,1},{2,8}}, 5);
  }
  public int[][] kClosest(int[][] points, int K) {
    if (points == null || points.length < K) {
      return null;
    }
    int start = 0;
    int end = points.length-1;
    while (true) {
      int index = kClosest(points, start, end);
      if (index == K-1) {
        return Arrays.copyOfRange(points, 0, K);
      }
      if (index > K-1) {
        end = index-1;
      } else {
        start = index+1;
      }
    }
  }
  private int kClosest(int[][] points, int start, int end) {
    int value = points[end][0]*points[end][0]+points[end][1]*points[end][1];
    int index = start;
    for (int i = start; i <= end; i++) {
      int distance = distance(points[i]);
      if (distance <= value) {
        if (i != index) {
          int[] temp = points[i];
          points[i] = points[index];
          points[index] = temp;
        }
        index++;
      }
    }
    return index-1;
  }
  private int distance(int[] point) {
    return point[0]*point[0]+point[1]*point[1];
  }
}
