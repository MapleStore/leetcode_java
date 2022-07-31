package darren.gong.leetcode;

public class MinimumMoves1246 {
    public int minimumMoves(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        // 1个数字直接删除
        // 2个数字 相等直接删除 不相等删除两次
        // i ~ j arr[i] == arr[j] 等于dp[i+1] dp[j-1]
        int length = arr.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < arr.length-1; i++) {
            dp[i][i+1] = arr[i] == arr[i+1] ? 1 : 2;
        }
        for (int scale = 3; scale <= arr.length; scale++) {
            for (int startIndex = 0; startIndex <= arr.length-scale; startIndex++) {
                int endIndex = startIndex+scale-1;
                dp[startIndex][endIndex] = scale;
                for (int mid = startIndex; mid < endIndex; mid++) {
                    dp[startIndex][endIndex] = Math.min(dp[startIndex][endIndex], dp[startIndex][mid]+dp[mid+1][endIndex]);
                }
                dp[startIndex][endIndex] = arr[startIndex] == arr[endIndex] ?
                        Math.min(dp[startIndex][endIndex], dp[startIndex+1][endIndex-1]) : dp[startIndex][endIndex];
            }
        }
        return dp[0][length-1];
    }
}
