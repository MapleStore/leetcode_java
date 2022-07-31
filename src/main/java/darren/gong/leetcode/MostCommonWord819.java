package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String oneBan : banned) {
            bannedSet.add(oneBan.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char oneChar : paragraph.toCharArray()) {
            if ((oneChar >= 'a' && oneChar <= 'z') || (oneChar >= 'A' && oneChar <= 'Z')) {
                sb.append(oneChar);
            } else {
                if (sb.length() != 0) {
                    String lowString = sb.toString().toLowerCase();
                    if (!bannedSet.contains(lowString)) {
                        map.put(lowString, map.getOrDefault(lowString, 0)+1);
                    }
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.length() != 0) {
            String lowString = sb.toString().toLowerCase();
            if (!bannedSet.contains(lowString)) {
                map.put(lowString, map.getOrDefault(lowString, 0)+1);
            }
        }

        String result = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxValue < entry.getValue()) {
                result = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return result;
    }
}
