package darren.gong.leetcode;

public class FindKthNumber_440 {
  public int findKthNumber(int n, int k) {
    int index = 1;
    int prefix = 1;
    while (index < k) {
      int count = countPrefix(prefix, n);
      if (index+count <= k) {
        index += count;
        prefix++;
      } else if (index+count > k){
        index++;
        prefix *= 10;
      }
    }
    return prefix;
  }
  private int countPrefix(int prefix, int up) {
    long current = prefix;
    long next = prefix+1;
    long count = 0;
    while (current <= up) {
      count += Math.min(next, up+1)-current;
      current *= 10;
      next *= 10;
    }
    return (int)count;
  }
}
