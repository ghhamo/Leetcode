import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char current = expression.charAt(i);
            if (current >= '0' && current <= '9') {
                num.append(current);
            } else {
                operands.add(Integer.parseInt(String.valueOf(num)));
                operators.add(current);
                num = new StringBuilder();
            }
        }
        operands.add(Integer.parseInt(String.valueOf(num)));
        return rec(operands, operators, expression);
    }
    public List<Integer> rec(List<Integer> nums, List<Character> signs, String exp) {

        return rec(nums, signs, exp);
    }
}