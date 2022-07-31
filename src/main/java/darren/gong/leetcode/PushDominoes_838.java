package darren.gong.leetcode;

public class PushDominoes_838 {
  // 838. 推多米诺
  public String pushDominoes(String dominoes) {
    int length = dominoes.length();
    int maxPower = 1000000;
    int[] rightPower = new int[length];
    int[] leftPower = new int[length];
    for (int i = 0; i < length; i++) {
      char current = dominoes.charAt(i);
      if (current == 'R') {
        rightPower[i] = maxPower;
      } else if (current == 'L') {
        rightPower[i] = 0;
      } else {
        rightPower[i] = i == 0 ? 0 : Math.max(0, rightPower[i-1]-1);
      }
    }
    for (int i = length-1; i >= 0; i--) {
      char current = dominoes.charAt(i);
      if (current == 'L') {
        leftPower[i] = maxPower;
      } else if (current == 'R') {
        leftPower[i] = 0;
      } else {
        leftPower[i] = i == length-1 ? 0 : Math.max(0, leftPower[i+1]-1);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (leftPower[i] == rightPower[i]) {
        sb.append('.');
      } else if (leftPower[i] > rightPower[i]) {
        sb.append('L');
      } else {
        sb.append('R');
      }
    }
    return sb.toString();
  }
}
