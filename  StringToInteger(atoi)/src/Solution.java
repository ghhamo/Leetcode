class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        int space;
        boolean minus = false;
        long result = 0;
        for (space = 0; space < len && s.charAt(space) == ' '; space++) {
        }
        if (space >= len) {
            return 0;
        }
        char cur = s.charAt(space);
        if (cur == '-') {
            minus = true;
            space++;
        } else if (cur == '+') {
            space++;
        }
        for (int i = space; i < len; i++) {
            char currentChar = s.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') {
                result = result * 10 + currentChar - '0';
                if (result > Integer.MAX_VALUE) {
                    break;
                }
            } else break;
        }
        if (minus) {
            result *= -1;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}