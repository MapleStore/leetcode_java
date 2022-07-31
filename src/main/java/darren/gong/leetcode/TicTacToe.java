package darren.gong.leetcode;

public class TicTacToe {
    private int[] player1Diagonal = new int[2];
    private int[] player1Row;
    private int[] player1Col;
    private int[] player2Diagonal = new int[2];
    private int[] player2Row;
    private int[] player2Col;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        player1Row = new int[n];
        player1Col = new int[n];

        player2Row = new int[n];
        player2Col = new int[n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            if (++player1Col[col] == n) return 1;
            if (++player1Row[row] == n) return 1;
            if (row == col) {
                if (++player1Diagonal[0] == n) return 1;
            }
            if (row+col == n-1) {
                if (++player1Diagonal[1] == n) return 1;
            }
        } else {
            if (++player2Col[col] == n) return 2;
            if (++player2Row[row] == n) return 2;
            if (row == col) {
                if (++player2Diagonal[0] == n) return 2;
            }
            if (row+col == n-1) {
                if (++player2Diagonal[1] == n) return 2;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */