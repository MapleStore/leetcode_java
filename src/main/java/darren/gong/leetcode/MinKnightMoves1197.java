package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinKnightMoves1197 {
    public static void main(String[] args) {
        MinKnightMoves1197 minKnightMoves1197 = new MinKnightMoves1197();
        minKnightMoves1197.minKnightMoves(2,112);
    }
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        x = Math.abs(x);
        y = Math.abs(y);
        boolean[][] visited = new boolean[666][666];
        visited[333][333] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int[][] directions = new int[][]{{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                int currentDis = Math.abs(x-currentX) + Math.abs(y-currentY);
                for (int[] direction : directions) {
                    int nextX = currentX+direction[0];
                    int nextY = currentY+direction[1];
                    if (nextX == x && nextY == y) {
                        return result;
                    }
                    int nextDis = Math.abs(x-nextX) + Math.abs(y-nextY);
                    if (nextDis > currentDis && currentDis >= 4) {
                        continue;
                    }
                    if (visited[333+nextX][333+nextY]) {
                        continue;
                    }
                    visited[333+nextX][333+nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            result++;
        }
        return -1;
    }
}
