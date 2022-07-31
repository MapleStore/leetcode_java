package darren.gong.leetcode;

public class New21Game_837 {
  // 837. 新21点
  public static void main(String[] args) {
    New21Game_837 new21Game_837 = new New21Game_837();
    new21Game_837.new21Game(3,3,2);
  }

  public double new21Game(int N, int K, int W) {
    double[] dp = new double[N+1];
    dp[0] = 1;
    double sum = 0;
    for (int i = 1; i <= N; i++) {
      sum += i-1 < K ? dp[i-1] : 0;
      sum -= i-W-1 >= 0 ? dp[i-W-1] : 0;
      dp[i] = sum/W;
    }
    double result = 0;
    for (int j = K; j < K+W; j++) {
      if (j <= N) {
        result += dp[j];
      }
    }
    return result;
  }

  public double new21Game2(int N, int K, int W) {
    double[] dp = new double[N+1];
    dp[0] = 1;
    for (int i = 1; i <= N; i++) {
      for (int from = i-W; from <= i-1; from++) {
        if (from >= 0 && from < K) {
          dp[i] += dp[from]/W;
        }
      }
    }
    double result = 0;
    for (int j = K; j < K+W; j++) {
      if (j <= N) {
        result += dp[j];
      }
    }
    return result;
  }
}
