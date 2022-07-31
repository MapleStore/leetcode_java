package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses93 {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backTracking(new ArrayList<>(s.length()), result,  s, 0);
        return result;
    }
    public void backTracking(List<String> oneResult, List<String> result, String s, int index) {
        if (index == s.length() || oneResult.size() == 4) {
            if (index == s.length() && oneResult.size() == 4) {
                result.add(appendResult(oneResult));
            }
        }
        for (int i = 1; i <= 3 && index+i <= s.length(); i++) {
            if (i > 1 && s.charAt(index) == '0') {
                break;
            }
            String oneIp = s.substring(index, index+i);
            if (Integer.valueOf(oneIp) > 255) {
                continue;
            }
            oneResult.add(oneIp);
            backTracking(oneResult, result, s, index + i);
            oneResult.remove(oneResult.size() - 1);
        }
        return;
    }
    public String appendResult(List<String> oneResult) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < oneResult.size(); i++) {
            if (i != 0) {
                sb.append('.');
            }
            sb.append(oneResult.get(i));
        }
        return sb.toString();
    }
}
