package darren.gong.leetcode;

public class NumWays1573 {
  public static void main(String[] args) {
    NumWays1573 numWays1573 = new NumWays1573();
    numWays1573.numWays("0000111111111111");
  }
  public int numWays(String s) {
    long MOD = (long)Math.pow(10, 9)+7;
    if (s == null || s.length() == 0) {
      return 0;
    }
    char[] chars = s.toCharArray();
    int oneNum = 0;
    int length = chars.length;
    for (int i = 0; i < length; i++) {
      if (chars[i] == '1') {
        oneNum++;
      }
    }
    if (oneNum == 0) {
      return (int)(((long)length-1)*((long)length-2)/2%MOD);
    }

    if (oneNum % 3 != 0) {
      return 0;
    }

    long oneNumEach = oneNum/3;
    long oneEnd = -1;
    long twoStart = -1;
    long twoEnd = -1;
    long threeStart = -1;

    for (int i = 0; i < length; i++) {
      if (chars[i] == '1') {
        if (oneEnd != -1 && twoStart == -1) {
          twoStart = i;
        }
        if (twoEnd != -1) {
          threeStart = i;
          break;
        }
        oneNumEach--;
        if (oneNumEach == 0) {
          oneNumEach = oneNum/3;
          if (oneEnd == -1) {
            oneEnd = i;
          } else {
            twoEnd = i;
          }
        }
      }
    }
    long result = (twoStart-oneEnd)*(threeStart-twoEnd)%MOD;
    return (int)result;
  }
}
