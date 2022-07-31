package darren.gong.leetcode;

import java.util.Arrays;

public class ValidTicTacToe794 {
    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        int length = board.length;
        int[] line1 = new int[length];
        int[] col1 = new int[length];
        int[] mid1 = new int[2];
        int[] line2 = new int[length];
        int[] col2 = new int[length];
        int[] mid2 = new int[2];
        int xNum = 0;
        int oNum = 0;
        boolean xWin = false;
        boolean oWin = false;

        for (int i = 0; i < length; i++) {
            String oneLine = board[i];
            for (int j = 0; j < length; j++) {
                if (oneLine.charAt(j) == 'X') {
                    line1[i]++;
                    col1[j]++;
                    if (i == j) {
                        mid1[0]++;
                    }
                    if (i+j == 2) {
                        mid1[1]++;
                    }
                    xNum++;
                }
                if (oneLine.charAt(j) == 'O') {
                    line2[i]++;
                    col2[j]++;
                    if (i == j) {
                        mid2[0]++;
                    }
                    if (i+j == 2) {
                        mid2[1]++;
                    }
                    oNum++;
                }
            }
        }
        if (arrayContains(line1, 3) || arrayContains(col1, 3) || arrayContains(mid1, 3)) {
            xWin = true;
        }
        if (arrayContains(line2, 3) || arrayContains(col2, 3) || arrayContains(mid2, 3)) {
            oWin = true;
        }
        if (xWin && oWin) {
            return false;
        }
        if (xWin) {
            return xNum == oNum+1;
        }
        if (oWin) {
            return xNum == oNum;
        }
        return xNum == oNum || xNum == oNum+1;
    }
    private boolean arrayContains(int[] nums, int target) {
        for (int num : nums) {
            if (target == num) {
                return true;
            }
        }
        return false;
    }
}
