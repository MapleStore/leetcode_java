package darren.gong.leetcode;

public class IsValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] sudoCache = new boolean[3][3][10];
        for (int i = 0; i < 9; i++) {
            boolean[] col = new boolean[10];
            boolean[] row = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if ((board[i][j]-'0' < 1 || board[i][j]-'0' > 9)) {
                        return false;
                    }
                    if (row[board[i][j]-'0']) {
                        return false;
                    } else {
                        row[board[i][j]-'0'] = true;
                    }
                    if (sudoCache[i/3][j/3][board[i][j]-'0']) {
                        return false;
                    } else {
                        sudoCache[i/3][j/3][board[i][j]-'0'] = true;
                    }
                }
                if (board[j][i] != '.') {
                    if ((board[j][i]-'0' < 1 || board[j][i]-'0' > 9)) {
                        return false;
                    }
                    if (col[board[j][i]-'0']) {
                        return false;
                    } else {
                        col[board[j][i]-'0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
