package darren.gong.leetcode;

public class CompareVersion165 {
    public static void main(String[] args) {

    }
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");
        int length = Math.max(vs1.length, vs2.length);
        int[] v1 = new int[length];
        int[] v2 = new int[length];

        for (int i = 0; i < vs1.length; i++) {
            v1[i] = Integer.parseInt(vs1[i]);
        }
        for (int i = 0; i < vs2.length; i++) {
            v2[i] = Integer.parseInt(vs2[i]);
        }
        for (int i = 0; i < length; i++) {
            if (v1[i] > v2[i]) {
                return 1;
            } else if (v1[i] < v2[i]) {
                return -1;
            }
        }
        return 0;
    }
}
