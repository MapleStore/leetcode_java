package darren.gong.leetcode;

import java.util.Stack;

public class NextGreaterElement556 {
    public static void main(String[] args) {
        NextGreaterElement556 nextGreaterElement556 = new NextGreaterElement556();
        nextGreaterElement556.nextGreaterElement(230241);// 230412
    }
    public int nextGreaterElement(int n) {
        char[] charArr = new StringBuilder(n+"").reverse().toString().toCharArray();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (; index < charArr.length; index++) {
            if (index > 0 && charArr[index] < charArr[index-1]) {
                break;
            }
        }
        if (index == charArr.length) {
            return -1;
        }
        for (int i = 0; i < index; i++) {
            if (charArr[i] > charArr[index]) {
                char temp = charArr[i];
                charArr[i] = charArr[index];
                charArr[index] = temp;
                break;
            }
        }
        int left = 0;
        int right = index-1;
        while (left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }
        int result = -1;
        try {
            result = Integer.valueOf(new StringBuilder(new String(charArr)).reverse().toString());
        } catch (Exception e) {
            return -1;
        }
        return result;
    }
}
