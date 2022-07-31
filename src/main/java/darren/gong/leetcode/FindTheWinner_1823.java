package darren.gong.leetcode;

public class FindTheWinner_1823 {
  public int findTheWinner(int n, int k) {
    int pos = 0;
    for (int i = 2; i <= n; i++) {
      pos = (pos+k)%i;
    }
    return pos+1;
  }
}
