package darren.gong.leetcode;

public class IsRobotBounded1041 {
  public boolean isRobotBounded(String instructions) {
    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    StringBuilder sb = new StringBuilder(instructions).append(instructions).append(instructions).append(instructions);
    int[] position = new int[]{0,0};
    int direction = 0;
    for (char operation : sb.toString().toCharArray()) {
      if (operation == 'G') {
        position[0] = position[0]+directions[direction][0];
        position[1] = position[1]+directions[direction][1];
      } else if (operation == 'L') {
        direction = direction == 0 ? 3 : direction-1;
      } else {
        direction = direction == 3 ? 0 : direction+1;
      }
    }
    return direction == 0 && position[0] == 0 && position[1] == 0;
  }
}
