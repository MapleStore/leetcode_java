package darren.gong.leetcode;

public class SampleStats1093 {
  public double[] sampleStats(int[] count) {
    int length = count.length;
    double[] result = new double[]{-1, 256, 0, 0, 0};
    //最小值、最大值、平均值、中位数和众数
    int num = 0;
    int midLeft;
    int midRight;

    double mostNum = 0;
    int mostAppear = 0;

    for (int i = 0; i < length; i++) {
      if (count[i] != 0 && result[0] == -1) {
        result[0] = i;
      }
      if (count[i] != 0) {
        result[1] = i;
      }
      result[2] += i*count[i];
      num += count[i];
      if (count[i] > mostAppear) {
        mostAppear = count[i];
        mostNum = i;
      }
    }
    result[2] = result[2]/num;
    result[4] = mostNum;

    if (num % 2 == 0) {
      midLeft = num/2;
    } else {
      midLeft = num/2+1;
    }
    midRight = num/2+1;

    num = 0;
    double midLeftValue = -1;
    double midRightValue = -1;
    for (int i = 0; i < length; i++) {
      num += count[i];
      if (num >= midLeft && midLeftValue == -1) {
        midLeftValue = i;
      }
      if (num >= midRight && midRightValue == -1) {
        midRightValue = i;
      }
    }
    result[3] = (midLeftValue+midRightValue)/2;
    return result;
  }
}
