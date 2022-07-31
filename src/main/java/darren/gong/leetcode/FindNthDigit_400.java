package darren.gong.leetcode;

public class FindNthDigit_400 {
  public static void main(String[] args) {
    FindNthDigit_400 findNthDigit_400 = new FindNthDigit_400();
    //findNthDigit_400.findNthDigit(1563254);
    findNthDigit_400.findNthDigit(1000000000);
  }
  public int findNthDigit(int n) {
    if (n < 10) {
      return n;
    }
    int digits = 1;
    long jump;
    while (n > (jump = ((long)Math.pow(10, digits)-(long)Math.pow(10, digits-1)) * digits)) {
      n -= jump;
      digits++;
    }
    int numIndex = (n-1)/digits;
    int targetNum = numIndex+(digits == 1 ? 0 : (int)Math.pow(10, digits-1));
    return String.valueOf(targetNum).charAt((n-1)%digits)-'0';
  }
}
