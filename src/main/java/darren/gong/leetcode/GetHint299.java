package darren.gong.leetcode;

public class GetHint299 {
  public String getHint(String secret, String guess) {
    int same = 0;
    int notSame = 0;
    int[] nums = new int[10];
    for (int i = 0; i < guess.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        same++;
      } else {
        nums[secret.charAt(i)-'0']++;
      }
    }
    for (int i = 0; i < guess.length(); i++) {
      if (secret.charAt(i) != guess.charAt(i) && nums[guess.charAt(i) - '0'] > 0) {
        nums[guess.charAt(i)-'0']--;
        notSame++;
      }
    }
    return same+"A"+notSame+"B";
  }
}
