import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(multiply("2345", "2145"));
        System.out.println(2345 * 2145);
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder start = new StringBuilder();
        int zeroCounter = 1;
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int curr2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int curr1 = num1.charAt(j) - '0';
                int currentAnswer = curr2 * curr1;
                currentAnswer += carry;
                carry = currentAnswer / 10;
                start.append(currentAnswer % 10);
            }
            if (carry > 0) {
                start.append(carry);
            }
            list.add(start.reverse());
            carry = 0;
            start = new StringBuilder();
            start.append("0".repeat(zeroCounter));
            zeroCounter++;
        }
        return add(list);
    }

    private static String add(List<StringBuilder> list) {
        StringBuilder start = new StringBuilder();
        StringBuilder cur = list.get(0);
        int carry = 0;
        for (int i = 1; i < list.size(); i++) {
            StringBuilder sec = list.get(i);
            int first = cur.length() - 1;
            int second = sec.length() - 1;
            int lastDigitOfFirstNum = 0;
            int lastDigitOfSecondNum = 0;
            while (first > -1 || second > -1) {
                if (first > -1) {
                    lastDigitOfFirstNum = cur.charAt(first) - '0';
                }
                if (second > -1) {
                    lastDigitOfSecondNum = sec.charAt(second) - '0';
                }
                int currentAnswer = lastDigitOfSecondNum + lastDigitOfFirstNum;
                currentAnswer += carry;
                carry = currentAnswer / 10;
                start.append(currentAnswer % 10);
                lastDigitOfFirstNum = 0;
                lastDigitOfSecondNum = 0;
                first--;
                second--;
            }
            if (carry > 0) {
                start.append(carry);
            }
            cur = start.reverse();
            carry = 0;
            start = new StringBuilder();
        }
        return String.valueOf(cur);
    }
}