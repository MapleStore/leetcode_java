package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = new int[][]{{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int xLength = grid.length;
        int yLength = grid.length;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0});
        grid[0][0] = 1;
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size-- > 0) {
                int[] current = queue.poll();
                if (current[0] == xLength-1 && current[1] == yLength-1) {
                    return length;
                }
                for (int[] direction : directions) {
                    int nextX = current[0] + direction[0];
                    int nextY = current[1] + direction[1];
                    if (nextX >= 0 && nextY >= 0 && nextX < xLength && nextY < yLength && grid[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX, nextY});
                        grid[nextX][nextY] = 1;
                    }
                }
            }

        }
        return -1;
    }
}
