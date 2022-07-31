package darren.gong.leetcode;

public class FindPoisonedDuration_495 {
  // 495. 提莫攻击
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int length = timeSeries.length;
    int poisonedEnd = -1;
    int result = 0;
    for (int i = 0; i < length; i++) {
      int newEnd = timeSeries[i]+duration;
      if (timeSeries[i] > poisonedEnd) {
        result += duration;
      } else {
        result += newEnd-poisonedEnd;
      }
      poisonedEnd = newEnd;
    }
    return result;
  }
}
