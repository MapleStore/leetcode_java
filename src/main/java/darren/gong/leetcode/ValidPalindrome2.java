package darren.gong.leetcode;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        int begin = 0;
        int end = s.length()-1;
        while (end > begin) {
            if (s.charAt(begin) != s.charAt(end)) {
                return isPalindRome(s, begin, end-1) || isPalindRome(s, begin+1, end);
            }
            end--;
            begin++;
        }
        return true;
    }
    public boolean isPalindRome(String input, int begin, int end) {
        while (end > begin) {
            if (input.charAt(begin) != input.charAt(end)) {
                return false;
            }
            end--;
            begin++;
        }
        return true;
    }
}
