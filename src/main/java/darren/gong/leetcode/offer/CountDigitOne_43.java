package darren.gong.leetcode.offer;

public class CountDigitOne_43 {
  public static void main(String[] args) {
    CountDigitOne_43 countDigitOne_43 = new CountDigitOne_43();
    countDigitOne_43.countDigitOne(12);
  }
  public int countDigitOne(int n) {
    // i位数 1出现了几次
    long[] f = new long[20];
    f[0] = 0;
    // i位数 最多有几个数
    long[] allNum = new long[20];
    allNum[0] = 1;
    for (int i = 1; i < 20; i++) {
      f[i] = f[i-1]*9+allNum[i-1]+f[i-1];// i-1位含1数量*9(i位不为1)+(i位为1 后面位数字任意)+(i位为1 后面i-1位1的数量)
      allNum[i] = 10*allNum[i-1];
    }

    int result = 0;
    char[] num = String.valueOf(n).toCharArray();
    for (int index = 0; index < num.length; index++) {
      int currentNum = num[index]-'0';
      int currentDigit = num.length-index;
      for (int i = 0; i < currentNum; i++) {
        if (i == 1) {
          result += allNum[currentDigit-1];
        }
        result += f[currentDigit-1];
      }
      if (currentNum == 1) {
        result += countValue(n, currentDigit-1)+1;
      }
    }
    return result;
  }
  private int countValue(int num, int digit) {
    if (digit == 0) {
      return 0;
    }
    int base = 1;
    for (int i = 1; i <= digit; i++) {
      base *= 10;
    }
    return num%base;
  }
}
