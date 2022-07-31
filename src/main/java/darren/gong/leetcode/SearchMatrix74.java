package darren.gong.leetcode;

public class SearchMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        int x = 0;
        int y = maxY-1;
        while (true) {
            if (x >= maxX || y >= maxY || x < 0 || y < 0) {
                return false;
            }
            if (matrix[x][y] == target) {
                return true;
            } else if (target > matrix[x][y]) {
                x++;
            } else {
                return searchMatrix(matrix[x], target);
            }
        }
    }
    private boolean searchMatrix(int[] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == matrix[mid]) {
                return true;
            } else if (target > matrix[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
}
