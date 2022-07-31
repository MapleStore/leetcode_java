package darren.gong.leetcode;

public class BaseNeg2_1017 {
  // 1017. 负二进制转换
  public static void main(String[] args) {
    BaseNeg2_1017 baseNeg2_1017 = new BaseNeg2_1017();
    baseNeg2_1017.baseNeg2(3);
  }
  public String baseNeg2(int N) {
    if (N == 0) {
      return "0";
    }
    int base = -2;
    int exponent = 31;
    StringBuilder sb = new StringBuilder();
    while (exponent >= 0) {
      double positive = 0;
      double negative = 0;
      double nextPositive = 0;
      double nextNegative = 0;
      double currentValue = Math.pow(base, exponent);
      if (exponent%2 == 0) {
        positive = (1-Math.pow(4, exponent/2+1))/(double) (-3);
        nextPositive = exponent == 0 ? 0 : (1-Math.pow(4, (exponent-2)/2+1))/(double) (-3);
      } else {
        negative = (-2)*(1-Math.pow(4, exponent/2+1))/(double) (-3);
        nextNegative = exponent == 1 ? 0 : (-2)*(1-Math.pow(4, (exponent-2)/2+1))/(double) (-3);
      }
      if (N > 0 && positive > 0 && positive >= N && nextPositive < N) {
        N -= currentValue;
        sb.append('1');
      } else if (N < 0 && negative < 0 && negative <= N && nextNegative > N) {
        N -= currentValue;
        sb.append('1');
      } else {
        sb.append('0');
      }
      exponent--;
    }
    return sb.toString().substring(sb.indexOf("1"));
  }
}
