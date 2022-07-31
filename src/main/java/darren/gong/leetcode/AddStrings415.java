package darren.gong.leetcode;

public class AddStrings415 {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        while (index1 >=0 || index2 >= 0) {
            int bit1 = index1 < 0 ? 0 : num1.charAt(index1) - '0';
            int bit2 = index2 < 0 ? 0 : num2.charAt(index2) - '0';
            int sum = bit1 + bit2 + carry;
            sb.append(sum%10);
            carry = sum/10;
            index1--;
            index2--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
