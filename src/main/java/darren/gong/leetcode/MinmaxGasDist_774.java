package darren.gong.leetcode;

public class MinmaxGasDist_774 {
  public static void main(String[] args) {
    MinmaxGasDist_774 minmaxGasDist_774 = new MinmaxGasDist_774();
    minmaxGasDist_774.minmaxGasDist(new int[]{1,2,3,4,5,6,7,8,9,10}, 18);
  }
  public double minmaxGasDist(int[] stations, int k) {
    double min = 0;
    double max = 100000000;
    while (max-min > 0.00000001) {
      double mid = (max+min)/2;
      if (valid(stations, k, mid)) {
        max = mid;
      } else {
        min = mid;
      }
    }
    return max;
  }
  private boolean valid(int[] stations, int k, double minDistance) {
    for (int i = 1; i < stations.length; i++) {
      k -= (int)((double)(stations[i]-stations[i-1])/minDistance);
    }
    return k >= 0;
  }
}
