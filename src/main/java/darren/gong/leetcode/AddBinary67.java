package darren.gong.leetcode;

public class AddBinary67 {
    public String addBinary(String a, String b) {
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int curNum = 0;
        while (curNum > 0 || aIndex >= 0 || bIndex >= 0) {
            curNum += aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
            curNum += bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;
            aIndex--;
            bIndex--;
            sb.append(curNum % 2);
            curNum = curNum >>> 1;
        }
        return sb.reverse().toString();
    }
}
