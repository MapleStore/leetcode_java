package darren.gong.leetcode;

public class CheckInclusion567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] charCount = new int[26];
        int charNumNeedToMatch = 0;
        for (char oneChar : s1.toCharArray()) {
            int index = oneChar-'a';
            if (charCount[index] == 0) {
                charNumNeedToMatch++;
            }
            charCount[oneChar-'a']++;
        }
        int left = 0;
        int right = 0;
        int windowCharNumMatch = 0;
        int[] windowCharCount = new int[26];
        while (right < s2.length()) {
            int index = s2.charAt(right)-'a';
            windowCharCount[index]++;
            if (windowCharCount[index] == charCount[index]) {
                windowCharNumMatch++;
            }
            if (windowCharNumMatch == charNumNeedToMatch) {
                return true;
            }
            right++;
            if (right-left == s1.length()) {
                index = s2.charAt(left)-'a';
                if (windowCharCount[index] == charCount[index]) {
                    windowCharNumMatch--;
                }
                windowCharCount[index]--;
                left++;
            }
        }
        return false;
    }
}
