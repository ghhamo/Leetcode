import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(stepsOfTowerOfHanoi(new Scanner(System.in).nextInt()));
    }

    static int stepsOfTowerOfHanoi(int n) {
        int tmp = 1;
        if (n == 1) {
            return tmp;
        }
        tmp += stepsOfTowerOfHanoi(n - 1) * 2;
        return tmp;
    }

}