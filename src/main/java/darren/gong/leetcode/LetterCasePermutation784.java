package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null || S.length() == 0) {
            result.add(S);
            return result;
        }
        dfs(S, 0, new StringBuilder(), result);
        return result;
    }
    private void dfs(String origin, int startIndex, StringBuilder sb, List<String> result) {
        if (sb.length() == origin.length()) {
            result.add(sb.toString());
            return;
        }
        char current = origin.charAt(startIndex);
        sb.append(current);
        dfs(origin, startIndex+1, sb, result);
        sb.deleteCharAt(sb.length()-1);
        if (current >= 'a' && current <= 'z') {
            sb.append((char)(current-'a'+'A'));
            dfs(origin, startIndex+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        } else if (current >= 'A' && current <= 'Z') {
            sb.append((char)(current-'A'+'a'));
            dfs(origin, startIndex+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}
