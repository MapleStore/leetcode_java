package darren.gong.leetcode;

import java.util.Random;

public class Rand10470 {
    public int rand10() {
        while (true) {
            int value = (rand7()-1)*7+rand7();
            if (value <= 40) {
                return value%10+1;
            }

            value = (value-40-1)*7+rand7();
            if (value <= 60) {
                return value%10+1;
            }
        }

    }
    // question: use rand7 generate rand10
    private int rand7() {
        return 0;
    }
}
