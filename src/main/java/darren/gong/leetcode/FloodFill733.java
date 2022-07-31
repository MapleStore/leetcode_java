package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int maxX = image.length;
        int maxY = image[0].length;
        int sameColor = image[sr][sc];
        if (sameColor == newColor) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                image[current[0]][current[1]] = newColor;
                for (int[] direction : directions) {
                    int nextX = current[0]+direction[0];
                    int nextY = current[1]+direction[1];
                    if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && image[nextX][nextY] == sameColor) {
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return image;
    }
}
