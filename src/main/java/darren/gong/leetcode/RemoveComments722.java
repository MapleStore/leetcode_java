package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class RemoveComments722 {
    public List<String> removeComments(String[] source) {
        List<String> result = new LinkedList<>();
        if (source == null || source.length == 0) {
            return result;
        }
        // /* */ //
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        for (String oneLine : source) {
            int index = 0;
            char[] charArr = oneLine.toCharArray();
            while (index < oneLine.length()) {
                if (inBlock && charArr[index] == '*' && index+1 < oneLine.length() && charArr[index+1] == '/') {
                    inBlock = false;
                    index++;
                } else if (!inBlock && charArr[index] == '/' && index+1 < oneLine.length() && charArr[index+1] == '/') {
                    index++;
                    break;
                } else if (!inBlock && charArr[index] == '/' && index+1 < oneLine.length() && charArr[index+1] == '*') {
                    inBlock = true;
                    index++;
                } else {
                    if (!inBlock) {
                        sb.append(charArr[index]);
                    }
                }
                index++;
            }
            if (!inBlock && sb.length() != 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}
