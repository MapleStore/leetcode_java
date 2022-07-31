package darren.gong.leetcode;

public class StrStr28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            if (needle.length() == 0) {
                return 0;
            }
            return -1;
        }
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }
    int[] getNext(String pattern) {
        int i = -1;
        int j = 0;
        int[] next = new int[pattern.length()];
        next[0] = -1;
        while (j < pattern.length()-1) {
            if (i == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                next[++j] = ++i;
            } else {
                i = next[i];
            }
        }
        return next;
    }
}
