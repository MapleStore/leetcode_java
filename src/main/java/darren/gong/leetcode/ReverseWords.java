package darren.gong.leetcode;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.reverseWords("a   example");
    }
    public String reverseWords(String s) {
        String[] result = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = result.length-1; i >= 0; i--) {
            if (result[i] != null && result[i].length() != 0) {
                sb.append(result[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
