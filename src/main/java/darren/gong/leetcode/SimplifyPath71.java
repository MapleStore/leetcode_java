package darren.gong.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        Deque<StringBuilder> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char oneChar : path.toCharArray()) {
            if (oneChar != '/') {
                sb.append(oneChar);
            } else if (sb.length() != 0) {
                if (sb.toString().equals("..")) {
                    if (!deque.isEmpty()) {
                        deque.pollLast();
                    }
                    sb = new StringBuilder();
                } else if (sb.toString().equals(".")) {
                    sb = new StringBuilder();
                } else {
                    deque.addLast(sb);
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.length() != 0) {
            if (sb.toString().equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (sb.toString().equals(".")) {
            } else {
                deque.addLast(sb);
            }
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append("/");
            result.append(deque.pollFirst());
        }
        return result.toString();
    }
}
