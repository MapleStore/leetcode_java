package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindRepeatedDnaSequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) {
            return new LinkedList<>();
        }
        Set<String> cache = new HashSet<>();
        StringBuilder sb = new StringBuilder(s);
        Set<String> result = new HashSet<>();
        for (int i = 0; i <= sb.length()-10; i++) {
            String temp = sb.substring(i, i+10);
            if (cache.contains(temp)) {
                result.add(temp);
            } else {
                cache.add(temp);
            }
        }
        return new ArrayList<>(result);
    }
}
