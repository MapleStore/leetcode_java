package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindShortestWay_499 {
  public static void main(String[] args) {
    FindShortestWay_499 findShortestWay_499 = new FindShortestWay_499();
    findShortestWay_499.findShortestWay(new int[][]{{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}}, new int[]{4,3}, new int[]{0,1});
  }
  private static class Point {
    private int[] position;
    private String path;
    public Point(int[] position, String path) {
      this.position = position;
      this.path = path;
    }
  }
  public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
    int maxX = maze.length;
    int maxY = maze[0].length;
    // d l r u
    boolean[][] visited = new boolean[maxX][maxY];
    int[][] directions = new int[][]{{1,0,'d'},{0,-1,'l'},{0,1,'r'},{-1,0,'u'}};
    String result = "impossible";
    PriorityQueue<Point> queue = new PriorityQueue<>((a,b)->{
      if (a.position[2] == b.position[2]) {
        return a.path.compareTo(b.path);
      } else {
        return a.position[2] - b.position[2];
      }
    });
    Point start = new Point(new int[]{ball[0], ball[1], 0}, "");
    queue.add(start);
    while (!queue.isEmpty()) {
      Point point = queue.poll();
      int[] current = point.position;
      String currentPath = point.path;
      if (current[0] == hole[0] && current[1] == hole[1]) {
        return currentPath;
      }
      if (visited[current[0]][current[1]]) {
        continue;
      }
      visited[current[0]][current[1]] = true;
      for (int[] direction : directions) {
        int[] next = findNextPos(maze, current, direction, hole);
        if (next[2] == 0) {
          continue;
        }
        next[2] += current[2];
        Point nextPoint = new Point(next, currentPath+(char)direction[2]);
        queue.add(nextPoint);
      }
    }
    return result;
  }
  private int[] findNextPos(int[][] maze, int[] current, int[] direction, int[] hole) {
    int[] result = new int[]{current[0], current[1], 0};
    while(true) {
      int nextX = result[0]+direction[0];
      int nextY = result[1]+direction[1];
      if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && maze[nextX][nextY] != 1) {
        result[0] = nextX;
        result[1] = nextY;
        result[2]++;
      } else {
        break;
      }
      if (nextX == hole[0] && nextY == hole[1]) {
        break;
      }
    }
    return result;
  }
}
