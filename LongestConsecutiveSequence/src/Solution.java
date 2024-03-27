import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 1;
        if (nums.length == 1) return 1;
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int ith : nums) {
            if (map.containsKey(ith)) {
                continue;
            }
            map.put(ith, ith);
            if (map.containsKey(ith - 1) || map.containsKey(ith + 1)) {
                int current = union(ith, map);
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }

    private int union(int current, Map<Integer, Integer> map) {
        int start = current;
        int end = current;
        if (map.containsKey(current + 1)) {
            end = map.get(current + 1);
        }
        if (map.containsKey(current - 1)) {
            start = map.get(current - 1);
        }
        map.put(end, start);
        map.put(start, end);
        return end - start + 1;
    }
}