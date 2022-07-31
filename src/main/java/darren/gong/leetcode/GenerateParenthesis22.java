package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        backTracking(new StringBuilder(), n, n, result);
        return result;
    }
    private void backTracking(StringBuilder sb, int leftNum, int rightNum, List<String> result) {
        if (leftNum == 0 && rightNum == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftNum > 0) {
            backTracking(sb.append('('), leftNum-1, rightNum, result);
            sb.deleteCharAt(sb.length()-1);
        }
        if (rightNum > 0 && rightNum > leftNum) {
            backTracking(sb.append(')'), leftNum, rightNum-1, result);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}
