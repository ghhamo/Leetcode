import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> visitedChars = new LinkedHashMap<>(s.length());
        int max = 0;
        int currentMax = 0;
        int currentStart = 0;
        for (int i = 0; i < s.length(); i++) {
            currentMax++;
            if (max > s.length() - i + currentMax) {
                break;
            }
            Integer duplicateIndex = visitedChars.get(s.charAt(i));
            if (duplicateIndex != null && duplicateIndex >= currentStart) {
                currentStart = duplicateIndex + 1;
                currentMax = i - duplicateIndex;
            }
            if (max < currentMax) {
                max = currentMax;
            }
            visitedChars.put(s.charAt(i), i);
        }
        return max;
    }
}