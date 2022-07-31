package darren.gong.leetcode;

public class MaxVacationDays568 {
  public static void main(String[] args) {
    MaxVacationDays568 maxVacationDays568 = new MaxVacationDays568();
    maxVacationDays568.maxVacationDays(new int[][]{{0,0,0},{0,0,0},{0,0,0}}, new int[][]{{1,1,1},{7,7,7},{7,7,7}});
    //maxVacationDays568.maxVacationDays(new int[][]{{0,1,1},{1,0,1},{1,1,0}}, new int[][]{{1,3,1},{6,0,3},{3,3,3}});
  }
  public int maxVacationDays(int[][] flights, int[][] days) {
    if (flights == null || flights.length == 0 || days == null || days.length == 0) {
      return -1;
    }
    // flights[i]: i城市可以去的所有城市, 可以到达则flights[i][j] = 1
    // days[i]: i城市各个周可以休息的天数, days[i][j] = i城市第j周能放几天
    int cityNum = days.length;
    int weeks = days[0].length;
    int[][] dp = new int[weeks+1][cityNum+1];
    int result = 0;
    boolean[] canReach = new boolean[cityNum];
    canReach[0] = true;
    // 第i周呆j城市最多放假时间, i和j需要-1表示实际下标
    for (int i = 1; i <= weeks; i++) {
      int currentWeek = i-1;
      for (int j = 1; j <= cityNum; j++) {
        int currentCity = j-1;
        if (canReach[currentCity]) {
          dp[i][j] = dp[i-1][j]+days[currentCity][currentWeek];
        }
        for (int from = 0; from < cityNum; from++) {
          if (canReach[from] && flights[from][currentCity] == 1) {
            dp[i][j] = Math.max(dp[i][j], dp[i-1][from+1]+days[currentCity][currentWeek]);
            canReach[currentCity] = true;
          }
        }
      }
    }
    for (int i = 0; i <= cityNum; i++) {
      result = Math.max(result, dp[weeks][i]);
    }
    return result;
  }
}
