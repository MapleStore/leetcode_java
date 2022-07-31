package darren.gong.leetcode;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        if (S == T) {
            return true;
        }
        if (S == null || T == null) {
            return false;
        }
        StringBuilder sbS = new StringBuilder();
        for (char oneChar : S.toCharArray()) {
            if (oneChar == '#') {
                if (sbS.length() != 0) {
                    sbS.deleteCharAt(sbS.length()-1);
                }
            } else {
                sbS.append(oneChar);
            }
        }
        StringBuilder sbT = new StringBuilder();
        for (char oneChar : T.toCharArray()) {
            if (oneChar == '#') {
                if (sbT.length() != 0) {
                    sbT.deleteCharAt(sbT.length()-1);
                }
            } else {
                sbT.append(oneChar);
            }
        }
        return sbS.toString().equals(sbT.toString());
    }
}
