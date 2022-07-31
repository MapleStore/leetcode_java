package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new LinkedList<>();
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return result;
        }
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] canReachP = new boolean[maxX][maxY];
        boolean[][] canReachA = new boolean[maxX][maxY];

        for (int i = 0; i < maxX; i++) {
            dfs(i, 0, matrix, canReachP, directions);
            dfs(i, maxY-1, matrix, canReachA, directions);
        }
        for (int j = 0; j < maxY; j++) {
            dfs(0, j, matrix, canReachP, directions);
            dfs(maxX-1, j, matrix, canReachA, directions);
        }
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }
    public void dfs(int x, int y, int[][] matrix, boolean[][] canReach, int[][] directions) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || canReach[x][y]) {
            return;
        }
        canReach[x][y] = true;
        for (int[] direction : directions) {
            int nextX = x+direction[0];
            int nextY = y+direction[1];
            if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && matrix[nextX][nextY] >= matrix[x][y]) {
                dfs(nextX, nextY, matrix, canReach, directions);
            }
        }
        return;
    }
}
