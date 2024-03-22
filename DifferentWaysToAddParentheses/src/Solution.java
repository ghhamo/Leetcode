import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current >= '0' && current <= '9') {
                stringBuilder.append(current);
                continue;
            }
            operators.add(current);
            numbers.add(Integer.parseInt(String.valueOf(stringBuilder)));
            stringBuilder = new StringBuilder();
        }
        return rec(expression, numbers, new ArrayList<>());
    }

    public List<Integer> rec(String expression, List<Integer> numbers, List<Integer> results) {

    }
}