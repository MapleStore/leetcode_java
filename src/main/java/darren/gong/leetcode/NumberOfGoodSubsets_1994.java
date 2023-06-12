package darren.gong.leetcode;

public class NumberOfGoodSubsets_1994 {
  public static void main(String[] args) {
    NumberOfGoodSubsets_1994 numberOfGoodSubsets_1994 = new NumberOfGoodSubsets_1994();
    numberOfGoodSubsets_1994.numberOfGoodSubsets(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30});
  }
  private final int MOD = 1000000007;
  public int numberOfGoodSubsets(int[] nums) {
    int[] count = new int[31];
    long[] allDivides = new long[31];
    for (int i = 2; i <= 30; i++) {
      allDivides[i] = divideNotSamePrime(i);
    }
    for (int num : nums) {
      count[num]++;
    }
    long mask = 0;
    for (int num = 0; num <= 30; num++) {
      if (count[num] > 0 && allDivides[num] > 0) {
        mask |= (1<<num);
      }
    }

    long result = 0;
    for (long sub = mask; sub > 0; sub = (sub-1)&mask) {
      long visited = 0;
      long oneResult = 1;
      long tempSub = sub;
      while (tempSub != 0) {
        long lowBit = lowBit(tempSub);
        tempSub -= lowBit;
        int num = countZero(lowBit);
        if ((allDivides[num]&visited) != 0) {
          oneResult = 0;
          break;
        }
        visited |= allDivides[num];
        oneResult *= count[num];
        oneResult %= MOD;
      }
      result += oneResult;
      result %= MOD;
    }
    return (int) ((pow(2, count[1])*result)%MOD);
  }
  private long pow(int base, int count) {
    if (count == 0) {
      return 1;
    }
    if (count == 1) {
      return base;
    }
    return count%2 == 0 ? (pow(base, count>>1)*pow(base, count>>1))%MOD : (pow(base, count>>1)*pow(base, count>>1)*base)%MOD;
  }
  private long divideNotSamePrime(int num) {
    if (num < 2) {
      return 0;
    }
    long val = 0;
    for (int i = 2; i <= num; i++) {
      if (num%i != 0) {
        continue;
      }
      val |= (1L << i);
      num /= i;
      if (num%i == 0) {
        return 0;
      }
    }
    return val;
  }
  private long lowBit(long num) {
    return num&-num;
  }
  private int countZero(long num) {
    int count = 0;
    while (num != 1) {
      count++;
      num = num>>1;
    }
    return count;
  }
}
