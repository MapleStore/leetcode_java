package darren.gong.leetcode;

public class Rotate0107 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int N = matrix.length;
        int startY = 0;
        int endY = N-1;
        for (int n = 0; n < N/2; n++) {
            for (int j = startY; j < endY; j++) {
                int x = n;
                int y = j;
                int preValue = matrix[x][y];
                for (int side = 0; side < 4; side++) {
                    int nextX;
                    int nextY;

                    nextX = y;
                    nextY = endY-x+n;

                    int temp = matrix[nextX][nextY];
                    matrix[nextX][nextY] = preValue;
                    preValue = temp;
                    x = nextX;
                    y = nextY;
                }
            }
            startY++;
            endY--;
        }
        return;
    }
}
