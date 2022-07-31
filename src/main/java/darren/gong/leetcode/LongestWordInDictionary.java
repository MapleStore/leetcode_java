package darren.gong.leetcode;

import java.util.List;

public class LongestWordInDictionary {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String target: d) {
            if (target.length() < result.length() || (result.length() == target.length() && target.compareTo(result) > 0)) {
                continue;
            }
            int inputIndex = 0;
            int targetIndex = 0;
            while (inputIndex < s.length() && targetIndex < target.length()) {
                if (target.charAt(targetIndex) == s.charAt(inputIndex)) {
                    targetIndex++;
                }
                inputIndex++;
            }
            if (targetIndex >= target.length()) {
                result = target;
            }
        }
        return result;
    }
}
