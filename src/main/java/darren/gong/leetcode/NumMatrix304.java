package darren.gong.leetcode;

public class NumMatrix304 {
    public static void main(String[] args) {
        NumMatrix304 numMatrix304 = new NumMatrix304(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
    }
    int[][] matrix = null;
    public NumMatrix304(int[][] matrix) {
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int left = j-1 >= 0 ? matrix[i][j-1] : 0;
                int up = i-1 >= 0 ? matrix[i-1][j] : 0;
                int leftUp = i-1 >= 0 && j-1 >= 0 ? matrix[i-1][j-1] : 0;
                matrix[i][j] = left+up-leftUp+matrix[i][j];
            }
        }
        return;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = col1-1 >= 0 ? matrix[row2][col1-1] : 0;
        int up = row1-1 >= 0 ? matrix[row1-1][col2] : 0;
        int leftUp = row1-1 >= 0 && col1-1 >= 0 ? matrix[row1-1][col1-1] : 0;
        return matrix[row2][col2]-left-up+leftUp;
    }
}
