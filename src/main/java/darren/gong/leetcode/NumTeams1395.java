package darren.gong.leetcode;

public class NumTeams1395 {
  public int numTeams(int[] rating) {
    int length = rating.length;
    int result = 0;
    for (int i = 1; i < length-1; i++) {
      int leftSmall = 0;
      int leftBigger = 0;
      int rightSmall = 0;
      int rightBigger = 0;
      for (int j = 0; j < i; j++) {
        if (rating[j] < rating[i]) {
          leftSmall++;
        }
        if (rating[j] > rating[i]) {
          leftBigger++;
        }
      }
      for (int j = i+1; j < length; j++) {
        if (rating[i] > rating[j]) {
          rightSmall++;
        }
        if (rating[i] < rating[j]) {
          rightBigger++;
        }
      }
      result += leftSmall*rightBigger+leftBigger*rightSmall;
    }
    return result;
  }
}
