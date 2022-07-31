package darren.gong.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveKdigits402 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char oneNum : num.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && oneNum - '0' < deque.peekLast() - '0') {
                deque.pollLast();
                k--;
            }
            deque.add(oneNum);
        }
        while (!deque.isEmpty() && deque.getFirst().equals('0')) {
            deque.poll();
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty() && deque.size() > k) {
            sb.append(deque.poll());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
