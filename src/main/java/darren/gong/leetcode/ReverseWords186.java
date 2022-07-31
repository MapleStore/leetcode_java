package darren.gong.leetcode;

public class ReverseWords186 {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int pre = -1;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                int start = pre+1;
                int end = i-1;
                while (start < end) {
                    char temp = s[start];
                    s[start] = s[end];
                    s[end] = temp;
                    start++;
                    end--;
                }
                pre = i;
            }
        }
        int start = 0;
        int end = s.length-1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        return;
    }
}
