package darren.gong.leetcode;

public class RepeatedSubstringPattern459 {
    public boolean repeatedSubstringPattern(String s) {
        String source = (s+s).substring(1);
        String pattern = s;
        int[] next = getNext(s);
        int sourceIndex = 0;
        int patternIndex = 0;
        while (sourceIndex < source.length() && patternIndex < pattern.length()) {
            if (patternIndex == -1 || source.charAt(sourceIndex) == pattern.charAt(patternIndex)) {
                sourceIndex++;
                patternIndex++;
            } else {
                patternIndex = next[patternIndex];
            }
        }
        if (sourceIndex-pattern.length() < pattern.length()-1) {
            return true;
        }
        return false;
    }
    private int[] getNext(String s) {
        int i = 0;
        int j = -1;
        int[] next = new int[s.length()];
        next[0] = -1;
        while (i < next.length-1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
