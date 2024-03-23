import java.util.*;

public class UF {

    public boolean equationsPossible(String[] equations) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder unequals = new StringBuilder();
        for (String equation : equations) {
            char first = equation.charAt(0);
            char second = equation.charAt(3);
            if (equation.startsWith("==", 1)) {
                if (map.containsKey(first)) {
                    if (!map.containsKey(second)) {
                        map.put(second, map.get(first));
                    } else union(second, first, map);
                } else if (map.containsKey(second)) {
                    if (!map.containsKey(first)) {
                        map.put(first, map.get(second));
                    } else union(first, second, map);
                } else {
                    map.put(first, first);
                    map.put(second, first);
                }
            } else {
                if (first == second) return false;
                unequals.append(first).append(second);
            }
        }
        String sUnequals = unequals.toString();
        for (int i = 0; i < sUnequals.length(); i+=2) {
            char first = sUnequals.charAt(i);
            char second = sUnequals.charAt(i + 1);
            if (map.containsKey(first) && map.containsKey(second)) {
                if (map.get(first).equals(map.get(second))) return false;
            }
        }
        return true;
    }

    public void union(char first, char second, Map<Character, Character> map) {
        Set<Map.Entry<Character, Character>> entries = map.entrySet();
        char fCh = map.get(first);
        char sCh = map.get(second);
        for (Map.Entry<Character, Character> entry : entries) {
            if (entry.getValue().equals(sCh)) entry.setValue(fCh);
        }
    }
}
