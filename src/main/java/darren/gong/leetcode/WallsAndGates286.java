package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates286 {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            while (size-- > 0) {
                int[] coordinate = queue.poll();
                for (int[] direction : directions) {
                    int nextX = coordinate[0]+direction[0];
                    int nextY = coordinate[1]+direction[1];
                    if (nextX >= 0 && nextX < rooms.length && nextY >= 0 && nextY < rooms[0].length && rooms[nextX][nextY] > distance) {
                        rooms[nextX][nextY] = distance;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return;
    }
}
