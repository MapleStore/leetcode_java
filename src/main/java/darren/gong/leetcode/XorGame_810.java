package darren.gong.leetcode;

public class XorGame_810 {
  public boolean xorGame(int[] nums) {
    // 双数个数情况 仅全为0 会输， 但全0已经获胜，所以双数必胜 单数全为0胜
    int all = 0;
    for (int num : nums) {
      all ^= num;
    }
    if (all == 0) {
      return true;
    }
    return nums.length%2 == 0;
  }
}
