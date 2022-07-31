package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix542 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        Queue<int[]> queue = new LinkedList<>();
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int nextX = current[0]+direction[0];
                    int nextY = current[1]+direction[1];
                    if (nextX >= 0 && nextY >= 0 && nextX < maxX && nextY < maxY && matrix[nextX][nextY] == 1) {
                        matrix[nextX][nextY] = -distance;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            distance++;
        }
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (matrix[i][j] < 0) {
                    matrix[i][j] = -matrix[i][j];
                }
            }
        }
        return matrix;
    }
}
