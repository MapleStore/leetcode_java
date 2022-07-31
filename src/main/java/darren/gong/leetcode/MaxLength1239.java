package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLength1239 {
    public static void main(String[] args) {
        System.out.println(0x8000);
        MaxLength1239 maxLength1239 = new MaxLength1239();
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"));
        maxLength1239.maxLength(list);
    }
    private int result = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        for (int i = 0; i < arr.size(); i++) {
            dfs(arr, i, 0, 0);
        }
        return result;
    }
    private void dfs(List<String> arr, int pos, int visit, int length) {
        String current = arr.get(pos);
        int currentMask = getMask(current);
        if ((currentMask & visit) != 0 || currentMask == 0x80000000) {
            return;
        }
        result = Math.max(result, length + current.length());
        for (int i = pos+1; i < arr.size(); i++) {
            dfs(arr, i, visit | currentMask, length+current.length());
        }
        return;
    }
    private int getMask(String s) {
        int mask = 0;
        for (char oneChar : s.toCharArray()) {
            if ((mask & (1 << (oneChar - 'a'))) != 0) {
                return 0x80000000;
            }
            mask |= 1 << (oneChar - 'a');
        }
        return mask;
    }
}
