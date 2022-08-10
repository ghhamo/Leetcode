import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] array) {
        Set<Solution.Trio> trios = new HashSet<>(array.length * 3);
        List<List<Integer>> retVals = new LinkedList<>();
        Map<Integer, Integer> negatives = new LinkedHashMap<>(array.length / 2);
        Map<Integer, Integer> positives = new LinkedHashMap<>(array.length / 2);
        for (int j : array) {
            if (j < 0) {
                negatives.merge(j, 1, Integer::sum);
            } else {
                positives.merge(j, 1, Integer::sum);
            }
        }
        for (int first : positives.keySet()) {
            for (int second : negatives.keySet()) {
                int third = -1 * (first + second);
                if (third == first) {
                    if (positives.get(third) == 1) {
                        continue;
                    }
                } else if (third == second) {
                    if (negatives.get(third) == 1) {
                        continue;
                    }
                }
                if (third < 0) {
                    if (negatives.containsKey(third)) {
                        Solution.Trio trio = new Solution.Trio(first, second, third);
                        trios.add(trio);
                    }
                } else {
                    if (positives.containsKey(third)) {
                        Solution.Trio trio = new Solution.Trio(first, second, third);
                        trios.add(trio);
                    }
                }
            }
        }
        Integer integer = positives.get(0);
        if (integer != null && integer > 2) {
            Solution.Trio trio = new Solution.Trio(0, 0, 0);
            trios.add(trio);
        }
        for (Solution.Trio trio : trios) {
            List<Integer> integers = new ArrayList<>(3);
            integers.add(trio.first);
            integers.add(trio.second);
            integers.add(trio.third);
            retVals.add(integers);
        }
        return retVals;
    }

    record Trio(int first, int second, int third) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Trio trio)) return false;
            if (first == trio.first && second == trio.second && third == trio.third) {
                return true;
            } else if (first == trio.first && second == trio.third && third == trio.second) {
                return true;
            } else if (first == trio.second && second == trio.first && third == trio.third) {
                return true;
            } else if (first == trio.second && second == trio.third && third == trio.first) {
                return true;
            } else if (first == trio.third && second == trio.first && third == trio.second) {
                return true;
            } else
                return first == trio.third && second == trio.second && third == trio.first;
        }

        @Override
        public int hashCode() {
            return first + second + third;
        }
    }
}

