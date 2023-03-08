public class Solution {
    public static void main(String[] args) {
        System.out.println(Math.pow(34, -3));
        System.out.println(myPow(34, -3));
    }

    public static double myPow(double x, int n) {
        double answer = 1;
        boolean odd = false;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n % 2 != 0) {
            if (n < 0) {
                n += 1;
            } else {
                n -= 1;
            }
            odd = true;
        }
        answer *= myPow(x, n / 2);
        answer = answer * answer;
        if (odd) {
            if (n > 0) {
                answer *= x;
            } else {
                answer /= x;
            }
        }
        return answer;
    }
}