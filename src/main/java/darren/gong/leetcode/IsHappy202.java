package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsHappy202 {
    public boolean isHappy(int n) {
        Map<Integer, Integer> remember = new HashMap<>();
        while (n != 1) {
            if (remember.containsKey(n)) {
                return false;
            }
            int nextN = 0;
            int preN = n;
            while (n > 0) {
                int remainder = n % 10;
                nextN += remainder * remainder;
                n = n / 10;
            }
            remember.put(preN, nextN);
            n = nextN;
        }
        return true;
    }
}
