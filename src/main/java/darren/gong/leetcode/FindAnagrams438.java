package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new LinkedList<>();

        int[] pCharToTimes = new int[26];
        for (char oneChar : p.toCharArray()) {
            pCharToTimes[oneChar-'a'] += 1;
        }
        int charNeedToMatch = 0;
        for (int i = 0; i < 26; i++) {
            if (pCharToTimes[i] != 0) {
                charNeedToMatch++;
            }
        }
        int[] windowCharToTimes = new int[26];
        int windowMatch = 0;

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int index = s.charAt(right)-'a';
            windowCharToTimes[index]++;
            if (windowCharToTimes[index] == pCharToTimes[index]) {
                windowMatch++;
            }
            if (windowMatch == charNeedToMatch) {
                result.add(left);
            }
            right++;
            if (right-left == p.length()) {
                index = s.charAt(left)-'a';
                if (windowCharToTimes[index] == pCharToTimes[index]) {
                    windowMatch--;
                }
                windowCharToTimes[index]--;
                left++;
            }
        }
        return result;
    }
}
