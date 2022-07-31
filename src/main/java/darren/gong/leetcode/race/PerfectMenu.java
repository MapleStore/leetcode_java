package darren.gong.leetcode.race;

public class PerfectMenu {
  public static void main(String[] args) {
    PerfectMenu perfectMenu = new PerfectMenu();
    perfectMenu.perfectMenu(new int[]{3,2,4,1,2},
        new int[][]{{1,1,0,1,2},{2,1,4,0,0},{3,2,4,1,0}},
        new int[][]{{3,2},{2,4},{7,6}},
        50);
  }
  private int result = -1;
  public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
    dfs(materials, cookbooks, attribute, limit, 0, 0);
    return result;
  }
  private void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, int currentIndex, int currentDelicious) {
    if (limit <= 0) {
      result = Math.max(currentDelicious, result);
    }
    for (int i = currentIndex; i < cookbooks.length; i++) {
      if (!checkMaterials(materials, cookbooks[i])) {
        continue;
      }
      use(materials, cookbooks[i]);
      dfs(materials, cookbooks, attribute, limit-attribute[i][1], i+1, currentDelicious+attribute[i][0]);
      returnUse(materials, cookbooks[i]);
    }
  }
  private boolean checkMaterials(int[] materialsRemain, int[] need) {
    for (int i = 0; i < 5; i++) {
      if (materialsRemain[i] < need[i]) {
        return false;
      }
    }
    return true;
  }
  private void use(int[] materialsRemain, int[] need) {
    for (int i = 0; i < 5; i++) {
      materialsRemain[i] -= need[i];
    }
  }
  private void returnUse(int[] materialsRemain, int[] need) {
    for (int i = 0; i < 5; i++) {
      materialsRemain[i] += need[i];
    }
  }
}
