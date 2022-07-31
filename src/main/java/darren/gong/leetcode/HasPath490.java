package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class HasPath490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int maxX = maze.length;
        int maxY = maze[0].length;
        boolean[][] visited = new boolean[maxX][maxY];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                if (currentX == destination[0] && currentY == destination[1]) {
                    return true;
                }
                for (int[] direction : directions) {
                    int nextX = currentX+direction[0];
                    int nextY = currentY+direction[1];
                    while (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && maze[nextX][nextY] == 0) {
                        nextX += direction[0];
                        nextY += direction[1];
                    }
                    if (!visited[nextX-direction[0]][nextY-direction[1]]) {
                        queue.add(new int[]{nextX-direction[0], nextY-direction[1]});
                        visited[nextX-direction[0]][nextY-direction[1]] = true;
                    }
                }
            }
        }
        return false;
    }
}
