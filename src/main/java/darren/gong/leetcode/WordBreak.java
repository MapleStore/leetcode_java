package darren.gong.leetcode;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean []dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i && s.substring(0,i).endsWith(word)) {
                    dp[i] = dp[i]||dp[i-word.length()];
                }
            }
        }
        return dp[s.length()];
    }

}
