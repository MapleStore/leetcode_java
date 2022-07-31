package darren.gong.leetcode;

public class NumberToWords273 {
    private final String[] THOUSAND = {"", "Thousand", "Million", "Billion"};
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] LESS_THAN_HUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (num > 0) {
            if (num%1000 != 0) {
                result = new StringBuilder(helper(num%1000)+THOUSAND[index]+" ").append(result);
            }
            index++;
            num = num/1000;
        }
        return result.toString().trim();
    }
    private StringBuilder helper(int num) {
        if (num == 0) {
            return new StringBuilder();
        }
        if (num < 20) {
            return new StringBuilder(LESS_THAN_TWENTY[num]+" ");
        } else if (num < 100) {
            return new StringBuilder(LESS_THAN_HUNDRED[num/10]+" ").append(helper(num%10));
        } else {
            return new StringBuilder(LESS_THAN_TWENTY[num/100]+" "+"Hundred"+" ").append(helper(num%100));
        }
    }
}
