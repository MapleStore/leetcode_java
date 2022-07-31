package darren.gong.leetcode;

public class CountBattleships419 {
    public int countBattleships(char[][] board) {
        int maxX = board.length;
        int maxY = board[0].length;
        int result = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                result++;
            }
        }
        return result;
    }
}
