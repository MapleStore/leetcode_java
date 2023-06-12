package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanMouseWin_1728 {
  public static void main(String[] args) {
    CanMouseWin_1728 canMouseWin_1728 = new CanMouseWin_1728();
    System.out.println(canMouseWin_1728.canMouseWin(new String[]{
        "M.C...F"}, 1, 4));
    return;
  }

  private int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
  String[] grid;
  int catJump;
  int mouseJump;
  int maxX;
  int maxY;
  private Map<Long, Boolean> catCache = new HashMap<>();
  private Map<Long, Boolean> mouseCache = new HashMap<>();
  Set<Long> mouseVisited = new HashSet<>();
  public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
    this.grid = grid;
    this.maxX = grid.length;
    this.maxY = grid[0].length();
    this.catJump = catJump;
    this.mouseJump = mouseJump;
    int[] catStart = null;
    int[] mouseStart = null;
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i].charAt(j) == 'C') {
          catStart = new int[]{i, j};
        }
        if (grid[i].charAt(j) == 'M') {
          mouseStart = new int[]{i, j};
        }
      }
    }
    if (catStart[0] == mouseStart[0] && catStart[1] == mouseStart[1]) {
      return false;
    }
    return mouseWin(mouseStart[0], mouseStart[1], catStart[0], catStart[1], 0);
  }
  private boolean mouseWin(int mouseX, int mouseY, int catX, int catY, int mouseCount) {
    if (mouseVisited.contains(getKey(mouseX, mouseY, catX, catY))) {
      return false;
    }
    mouseVisited.add(getKey(mouseX, mouseY, catX, catY));

    long key = getKey(mouseX, mouseY, catX, catY, mouseCount);
    if (mouseCache.containsKey(key)) {
      mouseVisited.remove(getKey(mouseX, mouseY, catX, catY));
      return mouseCache.get(key);
    }
    if (mouseCount >= 1000) {
      mouseCache.put(key, false);
      mouseVisited.remove(getKey(mouseX, mouseY, catX, catY));
      return false;
    }
    for (int[] direction : directions) {
      for (int jump = 1; jump <= mouseJump; jump++) {
        int nextX = mouseX+jump*direction[0];
        int nextY = mouseY+jump*direction[1];
        if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || grid[nextX].charAt(nextY) == '#') {
          break;
        }
        if (grid[nextX].charAt(nextY) == 'F') {
          mouseCache.put(key, true);
          mouseVisited.remove(getKey(mouseX, mouseY, catX, catY));
          return true;
        }
        if (nextX == catX && nextY == catY) {
          continue;
        }
        //System.out.println("mouse jump x:"+nextX+" y:"+nextY+" cat pos x:"+catX+" y:"+catY);
        if (!catWin(catX, catY, nextX, nextY, mouseCount+1)) {
          mouseCache.put(key, true);
          mouseVisited.remove(getKey(mouseX, mouseY, catX, catY));
          return true;
        }
      }
    }
    mouseCache.put(key, false);
    mouseVisited.remove(getKey(mouseX, mouseY, catX, catY));
    return false;
  }
  private boolean catWin(int catX, int catY, int mouseX, int mouseY, int mouseCount) {
    long key = getKey(mouseX, mouseY, catX, catY, mouseCount);
    if (catCache.containsKey(key)) {
      return catCache.get(key);
    }
    for (int[] direction : directions) {
      for (int jump = 0; jump <= catJump; jump++) {
        int nextX = catX+jump*direction[0];
        int nextY = catY+jump*direction[1];
        if (nextX < 0 || nextX >= maxX || nextY < 0 || nextY >= maxY || grid[nextX].charAt(nextY) == '#') {
          break;
        }
        if (grid[nextX].charAt(nextY) == 'F' || (nextX == mouseX && nextY == mouseY)) {
          catCache.put(key, true);
          return true;
        }
        //System.out.println("cat jump x:"+nextX+" y:"+nextY+" mouse pos x:"+mouseX+" y:"+mouseY);
        if (!mouseWin(mouseX, mouseY, nextX, nextY, mouseCount)) {
          catCache.put(key, true);
          return true;
        }
      }
    }
    catCache.put(key, false);
    return false;
  }
  private long getKey(int mouseX, int mouseY, int catX, int catY, int count) {
    long result = mouseX;
    result = (result<<3)+mouseY;
    result = (result<<3)+catX;
    result = (result<<3)+catY;
    result = (result<<10)+count;
    return result;
  }
  private long getKey(int mouseX, int mouseY, int catX, int catY) {
    long result = mouseX;
    result = (result<<3)+mouseY;
    return result;
  }
}
