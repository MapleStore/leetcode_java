package darren.gong.leetcode;

public class CorpFlightBookings1109 {
  public static void main(String[] args) {
    CorpFlightBookings1109 corpFlightBookings1109 = new CorpFlightBookings1109();
    corpFlightBookings1109.corpFlightBookings(new int[][]{{1,2,10},{2,3,10}}, 5);
  }
  public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] up = new int[n];
    int[] down = new int[n];
    for (int[] booking : bookings) {
      up[booking[0]-1] += booking[2];
      down[booking[1]-1] -= booking[2];
    }
    int tempResult = 0;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      tempResult += up[i];
      result[i] = tempResult;
      tempResult += down[i];
    }
    return result;
  }
}
