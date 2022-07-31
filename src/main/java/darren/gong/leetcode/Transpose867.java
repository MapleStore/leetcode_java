package darren.gong.leetcode;

public class Transpose867 {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) {
            return new int[][]{};
        }
        int x = A.length;
        int y = A[0].length;
        int[][] result = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
