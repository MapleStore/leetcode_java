package darren.gong.leetcode.race;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConveyorBelt {
  public static void main(String[] args) {
    ConveyorBelt conveyorBelt = new ConveyorBelt();
    System.out.println(conveyorBelt.conveyorBelt(new String[]{
            ">^^>",
            "<^v>",
            "^v^<"},
        new int[]{0,0}, new int[]{2,3}));
  }

  public int conveyorBelt(String[] matrix, int[] start, int[] end) {
    int maxX = matrix.length;
    int maxY = matrix[0].length();

    int[][] minOp = new int[maxX][maxY];
    for (int[] minOpOne : minOp) {
      Arrays.fill(minOpOne, 99999);
    }
    Queue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
    Map<Character, int[]> directions = new HashMap<>();
    directions.put('^', new int[]{-1, 0});
    directions.put('v', new int[]{1, 0});
    directions.put('<', new int[]{0, -1});
    directions.put('>', new int[]{0, 1});

    queue.add(new int[]{start[0], start[1], 0});
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int currentX = current[0];
      int currentY = current[1];
      int cost = current[2];
      if (currentX == end[0] && currentY == end[1]) {
        return cost;
      }
      for (Map.Entry<Character, int[]> direction : directions.entrySet()) {
        int nextX = currentX+direction.getValue()[0];
        int nextY = currentY+direction.getValue()[1];
        int nextCost = cost+(direction.getKey().equals(matrix[currentX].charAt(currentY)) ? 0 : 1);
        if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || minOp[nextX][nextY] <= nextCost) {
          continue;
        }
        queue.add(new int[]{nextX, nextY, nextCost});
        minOp[nextX][nextY] = nextCost;
      }
    }
    return minOp[end[0]][end[1]];
  }
}
