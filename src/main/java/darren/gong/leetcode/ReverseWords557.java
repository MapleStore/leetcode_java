package darren.gong.leetcode;

public class ReverseWords557 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        StringBuilder tempSb = new StringBuilder();
        for (int i = s.length()-1; i >= -1; i--) {
            if (i == -1 || chars[i] == ' ') {
                tempSb.append(' ').append(sb);
                sb = tempSb;
                tempSb = new StringBuilder();
            } else {
                tempSb.append(chars[i]);
            }
        }
        return sb.toString().trim();
    }
}
