package darren.gong.leetcode;

public class GenerateMatrix59 {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int startX = 0;
        int startY = 0;
        int endX = n-1;
        int endY = n-1;
        int[][] result = new int[n][n];
        while (num <= n * n) {
            for (int y = startY; y <= endY; y++) result[startX][y] = num++;
            startX++;
            for (int x = startX; x <= endX; x++) result[x][endY] = num++;
            endY--;
            for (int y = endY; y >= startY; y--) result[endX][y] = num++;
            endX--;
            for (int x = endX; x >= startX; x--) result[x][startY] = num++;
            startY++;
        }
        return result;
    }
}
