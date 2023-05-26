class Solution {
    public boolean isPowerOfThreeByIterative(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;
        while (true) {
            if (n % 3 != 0) return false;
            if (n == 3) return true;
            n /= 3;
        }
    }
    public boolean isPowerOfThreeByRecursive(int n) {
        if (n == 1 || n == 3) return true;
        if (n <= 0 || n % 3 != 0) return false;
        return isPowerOfTwoByRecursive(n/3);
    }
}