class Solution {
    public boolean isPowerOfTwoByIterative(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;
        while (true) {
            if (n % 2 != 0) return false;
            if (n == 2) return true;
            n /= 2;
        }
    }
    public boolean isPowerOfTwoByRecursive(int n) {
        if (n == 1 || n == 2) return true;
        if (n <= 0 || n % 2 != 0) return false;
        return isPowerOfTwoByRecursive(n/2);
    }
}