package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList();
        backTracking(new StringBuilder(), result, digits, 0);
        return result;
    }
    public void backTracking(StringBuilder sb, List<String> result, String digits, int index){
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (char one : KEYS[digits.charAt(index)-'0'].toCharArray()) {
            sb.append(one);
            backTracking(sb, result, digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}
