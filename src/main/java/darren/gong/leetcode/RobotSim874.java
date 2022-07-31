package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class RobotSim874 {
  public static void main(String[] args) {
    RobotSim874 robotSim874 = new RobotSim874();
    robotSim874.robotSim(new int[]{-2,-1,-2,3,7}, new int[][]
    {{1,-3},{2,-3},{4,0},{-2,5},{-5,2},{0,0},{4,-4},{-2,-5},{-1,-2},{0,2}});
  }
  private static Map<Integer, int[]> directions = new HashMap<>();
  static {
    directions.put(0, new int[]{0, 1});
    directions.put(1, new int[]{1, 0});
    directions.put(2, new int[]{0, -1});
    directions.put(3, new int[]{-1, 0});
  }
  public int robotSim(int[] commands, int[][] obstacles) {
    Map<Integer, TreeSet<Integer>> xLineObstacles = new HashMap<>();
    Map<Integer, TreeSet<Integer>> yLineObstacles = new HashMap<>();

    for (int[] obstacle : obstacles) {
      TreeSet xSet = xLineObstacles.get(obstacle[1]);
      if (xSet == null) {
        xSet = new TreeSet();
        xLineObstacles.put(obstacle[1], xSet);
      }
      xSet.add(obstacle[0]);

      TreeSet ySet = yLineObstacles.get(obstacle[0]);
      if (ySet == null) {
        ySet = new TreeSet();
        yLineObstacles.put(obstacle[0], ySet);
      }
      ySet.add(obstacle[1]);
    }
    int result = 0;
    int currentDirection = 0;
    int[] currentPos = new int[]{0, 0};
    for (int command : commands) {
      if (command == -1) {
        currentDirection++;
        currentDirection = currentDirection%4;
        continue;
      }
      if (command == -2) {
        currentDirection += 3;
        currentDirection = currentDirection%4;
        continue;
      }
      int[] currentDis = directions.get(currentDirection);
      int[] nextPos = new int[]{currentPos[0]+currentDis[0]*command, currentPos[1]+currentDis[1]*command};
      if (nextPos[0] != currentPos[0]) {
        TreeSet<Integer> currentXObstacles = xLineObstacles.get(currentPos[1]);
        if (currentXObstacles != null && nextPos[0] > currentPos[0]) {
          Integer obstacleX = currentXObstacles.ceiling(currentPos[0]+1);
          nextPos[0] = (obstacleX != null && obstacleX <= nextPos[0]) ? obstacleX-1 : nextPos[0];
        }
        if (currentXObstacles != null && nextPos[0] < currentPos[0]) {
          Integer obstacleX = currentXObstacles.floor(currentPos[0]-1);
          nextPos[0] = (obstacleX != null && obstacleX >= nextPos[0]) ? obstacleX+1 : nextPos[0];
        }
      }

      if (nextPos[1] != currentPos[1]) {
        TreeSet<Integer> currentYObstacles = yLineObstacles.get(currentPos[0]);
        if (currentYObstacles != null && nextPos[1] > currentPos[1]) {
          Integer obstacleY = currentYObstacles.ceiling(currentPos[1]+1);
          nextPos[1] = (obstacleY != null && obstacleY <= nextPos[1]) ? obstacleY-1 : nextPos[1];
        }
        if (currentYObstacles != null && nextPos[1] < currentPos[1]) {
          Integer obstacleY = currentYObstacles.floor(currentPos[1]-1);
          nextPos[1] = (obstacleY != null && obstacleY >= nextPos[1]) ? obstacleY+1 : nextPos[1];
        }
      }
      result = Math.max(result, nextPos[0]*nextPos[0]+nextPos[1]*nextPos[1]);
      currentPos = nextPos;
    }
    return result;
  }

}
