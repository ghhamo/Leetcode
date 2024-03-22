class Solution {
    public int fibByIterative(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prev = 1;
        int prevOfPrev = 0;
        int current;
        for (int i = 2; i <= n; i++) {
            current = prev;
            prev += prevOfPrev;
            prevOfPrev = current;
        }
        return prev;
    }

    public int fibByRecursion(int n) {
        if (n == 0 || n == 1) return n;
        return fibByRecursion(n - 1) + fibByRecursion(n - 2);
    }
}