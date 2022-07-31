package darren.gong.leetcode;

import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        wordBreakII.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<String>[][]dp = new ArrayList[s.length()+1][wordDict.size()+1];
        dp[0][0] = new ArrayList<>(Arrays.asList(""));
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                dp[i][j] = new ArrayList<>();
                String curWord = wordDict.get(j);
                String curString = s.substring(0, i);
                if (i >= curWord.length() && curString.endsWith(curWord)) {
                    for (int k = 0; k < wordDict.size(); k++) {
                        if (dp[i-curWord.length()][k] == null) {
                            continue;
                        }
                        for (String pre : dp[i-curWord.length()][k]) {
                            dp[i][j].add(new StringBuilder(pre).append(" ").append(curWord).toString().trim());
                        }
                    }
                }
            }
        }
        ArrayList<String> result = new ArrayList<>(wordDict.size());
        for (int i = 0; i < wordDict.size(); i++) {
            result.addAll(dp[s.length()][i]);
        }
        return result;
    }
}
