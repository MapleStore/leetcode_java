package darren.gong.leetcode;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int reachNextGas = 0;
        int gasLength = gas.length;
        for (int i = 0; i < gasLength*2; i++) {
            if (reachNextGas < 0) {
                reachNextGas = 0;
                start = i;
            }
            int nowIndex = i%gasLength;
            reachNextGas += gas[nowIndex]-cost[nowIndex];
            if (reachNextGas >= 0 && (nowIndex+1)%gasLength == start) {
                return start;
            }
        }
        return -1;
    }
}
