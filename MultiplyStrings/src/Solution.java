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
        StringBuilder end = new StringBuilder();
        int zeroCounter = 1;
        int firstDigitOfCurrentNumber = -1;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int curr2 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            for (int j = num1.length() - 1; j >= 0; j--) {
                int curr1 = Integer.parseInt(String.valueOf(num1.charAt(j)));
                int currentAnswer = curr2 * curr1;
                if (firstDigitOfCurrentNumber > 0) {
                    currentAnswer += firstDigitOfCurrentNumber;
                    firstDigitOfCurrentNumber = -1;
                }
                Pair pair = parser(currentAnswer);
                if (pair.firstDigit > 0) {
                    firstDigitOfCurrentNumber = pair.firstDigit;
                }
                start.append(pair.lastDigit);
                start.append(end);
                end = start;
                start = new StringBuilder();
                if (j == 0) {
                    if (firstDigitOfCurrentNumber > 0) {
                        start.append(firstDigitOfCurrentNumber);
                        start.append(end);
                        list.add(start);
                    } else {
                        list.add(end);
                    }
                    firstDigitOfCurrentNumber = -1;
                    start = new StringBuilder();
                    end = new StringBuilder();
                    end.append("0".repeat(Math.max(0, zeroCounter)));
                    zeroCounter++;
                }
            }
        }
        return add(list);
    }

    private static String add(List<StringBuilder> list) {
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        StringBuilder cur = list.get(0);
        int firstDigitOfCurrentNumber = -1;
        for (int i = 1; i < list.size(); i++) {
            StringBuilder sec = list.get(i);
            int curI = cur.length() - 1;
            int curJ = sec.length() - 1;
            int curr1 = 0;
            int curr2 = 0;
            while (curI > -1 || curJ > -1) {
                if (curI > -1) {
                    curr1 = Integer.parseInt(String.valueOf(cur.charAt(curI)));
                }
                if (curJ > -1) {
                    curr2 = Integer.parseInt(String.valueOf(sec.charAt(curJ)));
                }
                int currentAnswer = curr1 + curr2;
                if (firstDigitOfCurrentNumber > 0) {
                    currentAnswer += firstDigitOfCurrentNumber;
                    firstDigitOfCurrentNumber = -1;
                }
                Pair pair = parser(currentAnswer);
                if (pair.firstDigit > 0) {
                    firstDigitOfCurrentNumber = pair.firstDigit;
                }
                start.append(pair.lastDigit);
                start.append(end);
                end = start;
                start = new StringBuilder();
                curr1 = 0;
                curr2 = 0;
                curI--;
                curJ--;
            }
            if (firstDigitOfCurrentNumber > 0) {
                start.append(firstDigitOfCurrentNumber);
                start.append(end);
                cur = start;
            } else {
                cur = end;
            }
            firstDigitOfCurrentNumber = -1;
            start = new StringBuilder();
            end = new StringBuilder();
        }
        return String.valueOf(cur);
    }

    private static Pair parser(int num) {
        String s = String.valueOf(num);
        if (s.length() > 1) {
            return new Pair(Integer.parseInt(String.valueOf(s.charAt(0))), s.charAt(1));
        }
        return new Pair(0, s.charAt(0));
    }

    record Pair(int firstDigit, char lastDigit) {
    }
}