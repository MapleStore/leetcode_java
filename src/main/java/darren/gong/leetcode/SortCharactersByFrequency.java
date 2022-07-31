package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main (String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        System.out.println(sortCharactersByFrequency.frequencySort("eeeee"));
    }
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        if (s.length() <= 0) {
            return result.toString();
        }
        Map<Character, Integer> map = new HashMap<>();
        int[] frequency = new int[52];
        for (char temp : s.toCharArray()) {
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        List<Character>[] sort = new ArrayList[s.length()+1];
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (sort[value] == null) {
                sort[value] = new ArrayList<>();
            }
            sort[value].add(key);
        }
        for (int i = sort.length-1; i >= 0; i--) {
            if (sort[i] == null) {
                continue;
            }
            for (Character one : sort[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(one);
                }
            }
        }
        return result.toString();
    }

}
