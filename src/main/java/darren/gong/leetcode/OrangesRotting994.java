package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting994 {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxX = grid.length;
        int maxY = grid[0].length;
        boolean[][] visited = new boolean[maxX][maxY];
        Queue<int[]> queue = new LinkedList<>();
        int result = -1;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            while (size-- > 0) {
                int[] current = queue.poll();
                grid[current[0]][current[1]] = 2;
                for (int[] direction : directions) {
                    int nextX = current[0]+direction[0];
                    int nextY = current[1]+direction[1];
                    if (nextX < 0 || nextX >= maxX) {
                        continue;
                    }
                    if (nextY < 0 || nextY >= maxY) {
                        continue;
                    }
                    if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                int orange = grid[i][j];
                if (orange == 1) {
                    return -1;
                }
                if (grid[i][j] == 2) {
                    cnt++;
                }
            }
        }
        return cnt > 0 ? result : 0;
    }
}
