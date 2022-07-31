package darren.gong.leetcode;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int maxX = grid.length;
        int maxY = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                result = Math.max(result, dfs(grid, maxX, maxY, i, j, directions));
            }
        }
        return result;
    }
    public int dfs(int[][] grid, int maxX, int maxY, int curX, int curY, int[][] directions) {
        int result = 1;
        grid[curX][curY] = 0;
        for (int[] direction : directions) {
            int nextX = curX + direction[0];
            int nextY = curY + direction[1];
            if (nextX >= 0 && nextY >= 0 && nextX < maxX && maxY < maxY && grid[nextX][nextY] == 1){
                result += dfs(grid, maxX, maxY, nextX, nextY, directions);
            }
        }
        return result;
    }
}
