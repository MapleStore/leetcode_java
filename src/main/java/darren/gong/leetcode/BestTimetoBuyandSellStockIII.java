package darren.gong.leetcode;

/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

示例 2:
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

示例 3:
输入: [7,6,4,3,1]
输出: 0
解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockIII bestTimetoBuyandSellStockIII = new BestTimetoBuyandSellStockIII();
        bestTimetoBuyandSellStockIII.maxProfit(new int[]{1,2,3,4,5});
        return;
    }

    public int maxProfit(int[] prices) {
        //第1天  第几次交易     交易状态 0：买入    1:卖出
        int [][][]dp = new int[prices.length+1][2][2];
        for (int i = 1; i <= prices.length; i++) {
            if (i == 1) {
                dp[i][0][0] = -prices[i-1];
                dp[i][0][1] = 0;

                dp[i][1][0] = -prices[i-1];
                dp[i][1][1] = 0;
            } else {
                dp[i][0][0] = Math.max(-prices[i-1], dp[i-1][0][0]);
                // 今天0次卖出 = 昨天卖出（今天无操作） 或 昨天0次买入
                dp[i][0][1] = Math.max(dp[i-1][0][0] + prices[i-1], dp[i-1][0][1]);

                // 今天1次买入 = 今天0次卖出，今天再买 昨天第一次买（今天无操作）
                dp[i][1][0] = Math.max(dp[i][0][1] - prices[i-1], dp[i-1][1][0]);
                // 今天1次卖出 = 昨天1次买入+卖出价格 或 昨天1次卖出（今天无操作）
                dp[i][1][1] = Math.max(dp[i-1][1][0] + prices[i-1], dp[i-1][1][1]);
            }
        }
        return dp[prices.length][1][1];
    }
}
