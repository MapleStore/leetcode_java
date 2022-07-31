package darren.gong.leetcode;

import java.util.Arrays;

public class LongestStrChain_1048 {
  // 1048. 最长字符串链
  public static void main(String[] args) {
    LongestStrChain_1048 longestStrChain_1048 = new LongestStrChain_1048();
    longestStrChain_1048.longestStrChain(new String[]{"wnyxmflkf","xefx","usqhb","ttmdvv","hagmmn","tmvv","pttmdvv","nmzlhlpr","ymfk","uhpaglmmnn","zckgh","hgmmn","isqxrk","isqrk","nmzlhpr","uysyqhxb","haglmmn","xfx","mm","wymfkf","tmdvv","uhaglmmn","mf","uhaglmmnn","mfk","wnymfkf","powttkmdvv","kwnyxmflkf","xx","rnqbhxsj","uysqhb","pttkmdvv","hmmn","iq","m","ymfkf","zckgdh","zckh","hmm","xuefx","mv","iqrk","tmv","iqk","wnyxmfkf","uysyqhb","v","m","pwttkmdvv"});
  }
  public int longestStrChain(String[] words) {
    Arrays.sort(words, (a,b)->a.length()-b.length());
    int length = words.length;
    int[] dp = new int[length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < length; i++) {
      for (int j = i-1; j >= 0; j--) {
        if (dp[j] <= dp[i]-1) {
          continue;
        }
        if (isChain(words[j], words[i])) {
          dp[i] = dp[j]+1;
        }
      }
    }
    int result = Integer.MIN_VALUE;
    for (int value : dp) {
      result = Math.max(result, value);
    }
    return result;
  }
  private boolean isChain(String shortS, String longS) {
    int shortLength = shortS.length();
    int longLength = longS.length();
    if (longLength-shortLength != 1) {
      return false;
    }
    int shortIndex = 0;
    int count = 0;
    for (char oneChar : longS.toCharArray()) {
      if (shortIndex < shortLength && shortS.charAt(shortIndex) == oneChar) {
        shortIndex++;
      } else {
        count++;
      }
      if (count > 1) {
        return false;
      }
    }
    return true;
  }
}
