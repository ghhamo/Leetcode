class Solution {
    public int reverse(int x) {
        long result = 0;
        int reminder;
        while (x != 0) {
            reminder = x % 10;
            result = result * 10 + reminder;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x = (x - reminder) / 10;
        }
        return (int) result;
    }
}