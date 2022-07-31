package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindCelebrity277 {
    public int findCelebrity(int n) {
        if (n == 1) {
            return 0;
        }
        Set<Integer> famousPeople = new HashSet<>(n);
        Set<Integer> nextFamousPeople = new HashSet<>(n);
        famousPeople.add(0);
        for (int i = 1; i < n; i++) {
            if (knows(0, i)) {
                famousPeople.add(i);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int oneFamousPeople : famousPeople) {
                if (knows(i, oneFamousPeople)) {
                    nextFamousPeople.add(oneFamousPeople);
                }
            }
            famousPeople = nextFamousPeople;
            nextFamousPeople = new HashSet<>(n);
        }
        if (famousPeople.size() != 1) {
            return -1;
        }
        int result = famousPeople.iterator().next();
        for (int i = 0; i < n; i++) {
            if (knows(result, i) && result != i) {
                return -1;
            }
        }
        return result;
    }
    boolean knows(int a, int b) {
        return true;
    }
}
