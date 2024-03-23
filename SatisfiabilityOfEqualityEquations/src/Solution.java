import java.util.*;

class Solution {

    public boolean equationsPossible(String[] equations) {
        List<Set<Character>> list = new LinkedList<>();
        List<String> unequals = new ArrayList<>();
        for (String equation : equations) {
            char first = equation.charAt(0);
            char second = equation.charAt(3);
            if (equation.startsWith("==", 1)) {
                f(first, second, list);
            } else {
                if (first == second) return false;
                unequals.add(equation);
            }
        }
        if (unequals.isEmpty()) return true;
        if (list.isEmpty()) return true;
        for (String unequal : unequals) {
            for (Set<Character> characters : list) {
                char first = unequal.charAt(0);
                char second = unequal.charAt(3);
                if (characters.contains(first) && characters.contains(second)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void f(char first, char second, List<Set<Character>> list) {
        boolean b = true;
        for (Set<Character> jth : list) {
            if (jth.contains(first) && jth.contains(second)) {
                b = false;
                break;
            }
            if (jth.contains(first)) {
                merge(second, jth, list);
                b = false;
                break;
            } else if (jth.contains(second)) {
                merge(first, jth, list);
                b = false;
                break;
            }
        }
        if (b) {
            Set<Character> set = new HashSet<>();
            set.add(first);
            set.add(second);
            list.add(set);
        }
    }

    public void merge(char ch, Set<Character> set, List<Set<Character>> list) {
        Iterator<Set<Character>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Set<Character> set1 = iterator.next();
            if (set1.contains(ch)) {
                set.addAll(set1);
                iterator.remove();
                return;
            }
        }
        set.add(ch);
    }
}