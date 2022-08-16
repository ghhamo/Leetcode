import java.util.*;

public class Solution {

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return Collections.emptyList();
        }
        Map<Character, List<String>> buttons = cacheLetterMappings(digits);
        return rec(0, buttons, digits);
    }

    static private List<String> rec(int index, Map<Character, List<String>> buttons, String digits) {
        char c = digits.charAt(index);
        List<String> letters = buttons.get(c);
        if (index == digits.length() - 1) {
            return letters;
        }
        List<String> subResult = rec(index + 1, buttons, digits);
        List<String> result = new ArrayList<>(subResult.size() * letters.size());
        for (String letter : letters) {
            for (String combination : subResult) {
                result.add(letter + combination);
            }
        }
        return result;
    }

    public static Map<Character, List<String>> cacheLetterMappings(String digits) {
        Map<Character, List<String>> buttons = new HashMap<>();
        int length = digits.length();
        for (int i = 0; i < length; i++) {
            List<String> letters = new ArrayList<>();
            switch (digits.charAt(i)) {
                case '2':
                    letters.add("a");
                    letters.add("b");
                    letters.add("c");
                    buttons.put('2', letters);
                    break;
                case '3':
                    letters.add("d");
                    letters.add("e");
                    letters.add("f");
                    buttons.put('3', letters);
                    break;
                case '4':
                    letters.add("g");
                    letters.add("h");
                    letters.add("i");
                    buttons.put('4', letters);
                    break;
                case '5':
                    letters.add("j");
                    letters.add("k");
                    letters.add("l");
                    buttons.put('5', letters);
                    break;
                case '6':
                    letters.add("m");
                    letters.add("n");
                    letters.add("o");
                    buttons.put('6', letters);
                    break;
                case '7':
                    letters.add("p");
                    letters.add("q");
                    letters.add("r");
                    letters.add("s");
                    buttons.put('7', letters);
                    break;
                case '8':
                    letters.add("t");
                    letters.add("u");
                    letters.add("v");
                    buttons.put('8', letters);
                    break;
                case '9':
                    letters.add("w");
                    letters.add("x");
                    letters.add("y");
                    letters.add("z");
                    buttons.put('9', letters);
                    break;
            }
        }

        return buttons;
    }
}
