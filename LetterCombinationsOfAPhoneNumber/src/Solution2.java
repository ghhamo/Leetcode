import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return new LinkedList<>();
        }
        HashMap<Integer, ArrayList<String>> buttons = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ArrayList<String> letters = new ArrayList<>();
            switch (digits.charAt(i)) {
                case '2':
                    letters.add("a");
                    letters.add("b");
                    letters.add("c");
                    buttons.put(2, letters);
                    break;
                case '3':
                    letters.add("d");
                    letters.add("e");
                    letters.add("f");
                    buttons.put(3, letters);
                    break;
                case '4':
                    letters.add("g");
                    letters.add("h");
                    letters.add("i");
                    buttons.put(4, letters);
                    break;
                case '5':
                    letters.add("j");
                    letters.add("k");
                    letters.add("l");
                    buttons.put(5, letters);
                    break;
                case '6':
                    letters.add("m");
                    letters.add("n");
                    letters.add("o");
                    buttons.put(6, letters);
                    break;
                case '7':
                    letters.add("p");
                    letters.add("q");
                    letters.add("r");
                    letters.add("s");
                    buttons.put(7, letters);
                    break;
                case '8':
                    letters.add("t");
                    letters.add("u");
                    letters.add("v");
                    buttons.put(8, letters);
                    break;
                case '9':
                    letters.add("w");
                    letters.add("x");
                    letters.add("y");
                    letters.add("z");
                    buttons.put(9, letters);
                    break;
                default:
                    return new LinkedList<>();
            }
        }
        if (n == 1) {
            return buttons.get(Integer.parseInt(digits));
        }
        return rec(0, buttons, digits, new ArrayList<>());
    }

    static private ArrayList<String> rec(int index, HashMap<Integer, ArrayList<String>> buttons, String digits, ArrayList<String> results) {
        ArrayList<String> subResult = new ArrayList<>();
        ArrayList<String> list = buttons.get(Integer.parseInt(String.valueOf(digits.charAt(index))));
        for (int j = 0; j < list.size(); j++) {
            if (results.size() > 0) {
                for (String result : results) {
                    String s = result + list.get(j);
                    subResult.add(s);
                }
            } else {
                results.addAll(list);
                return rec(++index, buttons, digits, results);
            }
        }
        if (index >= digits.length() - 1) {
            return subResult;
        }
        return rec(++index, buttons, digits, subResult);
    }
}
