package darren.gong.leetcode;

import java.util.Random;

public class Solution_478 {
  // 478. 在圆内随机生成点
  private double radius;
  private double x_center;
  private double y_center;
  private Random random = new Random();
  public Solution_478(double radius, double x_center, double y_center) {
    this.radius = radius;
    this.x_center = x_center;
    this.y_center = y_center;
  }
  // 拒绝采样法
  public double[] randPoint() {
    while (true) {
      double x = random.nextDouble()%radius;
      double y = random.nextDouble()%radius;
      if (x*x+y*y < radius*radius) {
        return new double[]{random.nextInt()%2 == 0 ? x_center+x : x_center-x, random.nextInt()%2 == 0 ? y_center+y : y_center-y};
      }
    }
  }
}
