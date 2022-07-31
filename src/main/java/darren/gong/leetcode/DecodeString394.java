package darren.gong.leetcode;

import java.util.Stack;

public class DecodeString394 {
    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        Stack<StringBuilder> sbStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (char oneChar : charArray) {
            if (oneChar == '[') {
                sbStack.add(sb);
                numStack.add(num);
                sb = new StringBuilder();
                num = 0;
            } else if (oneChar == ']') {
                int times = numStack.pop();
                StringBuilder pre = sbStack.pop();
                while (times-- > 0) {
                    pre.append(sb);
                }
                sb = pre;
            } else if (Character.isDigit(oneChar)) {
                num = num*10 + oneChar-'0';
            } else {
                sb.append(oneChar);
            }
        }
        return sb.toString();
    }
}
