package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        if (s.equals("")) {
            return "";
        }
        Set<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char []input = s.toCharArray();

        int end = input.length -1;
        int begin  = 0;
        while (end > begin) {
            if (!vowels.contains(input[begin])) {
                begin++;
                continue;
            }
            if (!vowels.contains(input[end])) {
                end--;
                continue;
            }
            char tempChar = input[begin];
            input[begin] = input[end];
            input[end] = tempChar;
            begin++;
            end--;
        }
        return new String(input);
    }
}