package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CleanRoom489 {
  private static interface Robot {
    // 若下一个方格为空，则返回true，并移动至该方格
    // 若下一个方格为障碍物，则返回false，并停留在原地
    boolean move();

    // 在调用turnLeft/turnRight后机器人会停留在原位置
    // 每次转弯90度
    void turnLeft();
    void turnRight();

    // 清理所在方格
    void clean();
  }
  private Set<Integer> visited = new HashSet<>();
  public void cleanRoom(Robot robot) {
    robot.clean();
    visited.add(0);

    // up
    int nextX = -1;
    int nextY = 0;
    if (!visited.contains(getHash(nextX, nextY)) && robot.move()) {
      visited.add(getHash(nextX, nextY));
      cleanRoomHelper(robot, new int[]{nextX, nextY}, 3);
    } else {
      visited.add(getHash(nextX, nextY));
      robot.turnRight();
      robot.turnRight();
    }
    // down
    nextX = 1;
    nextY = 0;
    if (!visited.contains(getHash(nextX, nextY)) && robot.move()) {
      visited.add(getHash(nextX, nextY));
      cleanRoomHelper(robot, new int[]{nextX, nextY}, 1);
    } else {
      visited.add(getHash(nextX, nextY));
      robot.turnRight();
      robot.turnRight();
    }
    // left
    nextX = 0;
    nextY = -1;
    robot.turnLeft();
    if (!visited.contains(getHash(nextX, nextY)) && robot.move()) {
      visited.add(getHash(nextX, nextY));
      cleanRoomHelper(robot, new int[]{nextX, nextY}, 2);
    } else {
      visited.add(getHash(nextX, nextY));
      robot.turnRight();
      robot.turnRight();
    }
    // right
    nextX = 0;
    nextY = 1;
    if (!visited.contains(getHash(nextX, nextY)) && robot.move()) {
      visited.add(getHash(nextX, nextY));
      cleanRoomHelper(robot, new int[]{nextX, nextY}, 4);
    } else {
      visited.add(getHash(nextX, nextY));
      robot.turnRight();
      robot.turnRight();
    }
  }

  private void cleanRoomHelper(Robot robot, int[] current, int lastDir) {
    robot.clean();
    // face up
    if (lastDir == 1) {
      robot.turnRight();
      robot.turnRight();
    } else if (lastDir == 2) {
      robot.turnRight();
    } else if (lastDir == 4) {
      robot.turnLeft();
    }

    // up
    int nextX = current[0]-1;
    int nextY = current[1];
    if (!visited.contains(getHash(nextX, nextY)) && robot.move()) {
      visited.add(getHash(nextX, nextY));
      cleanRoomHelper(robot, new int[]{nextX, nextY}, 3);
    } else {
      visited.add(getHash(nextX, nextY));
      robot.turnRight();
      robot.turnRight();
    }
    // down
    nextX = current[0]+1;
    nextY = current[1];
    if (!visited.contains(getHash(nextX, nextY)) && robot.move()) {
      visited.add(getHash(nextX, nextY));
      cleanRoomHelper(robot, new int[]{nextX, nextY}, 1);
    } else {
      visited.add(getHash(nextX, nextY));
      robot.turnRight();
      robot.turnRight();
    }
    // left
    nextX = current[0];
    nextY = current[1]-1;
    robot.turnLeft();
    if (!visited.contains(getHash(nextX, nextY)) && robot.move()) {
      visited.add(getHash(nextX, nextY));
      cleanRoomHelper(robot, new int[]{nextX, nextY}, 2);
    } else {
      visited.add(getHash(nextX, nextY));
      robot.turnRight();
      robot.turnRight();
    }
    // right
    nextX = current[0];
    nextY = current[1]+1;
    if (!visited.contains(getHash(nextX, nextY)) && robot.move()) {
      visited.add(getHash(nextX, nextY));
      cleanRoomHelper(robot, new int[]{nextX, nextY}, 4);
    } else {
      visited.add(getHash(nextX, nextY));
      robot.turnRight();
      robot.turnRight();
    }

    // face up
    robot.turnRight();
    // return last
    if (lastDir == 2) {
      robot.turnRight();
    } else if (lastDir == 3) {
      robot.turnRight();
      robot.turnRight();
    } else if (lastDir == 4) {
      robot.turnLeft();
    }
    robot.move();
  }
  private int getHash(int x, int y) {
    return (x+10000)*10000+y;
  }
}
