import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.parallelSort(numbers);
        int n = numbers.length;
        int right = n - 1;
        int i = 0;
        if (right < 2 || numbers[right] < 0) {
            return res;
        }
        while (numbers[i] <= 0 && i < n-2) {
            int target = -numbers[i];
            int left = i + 1;
            right = n - 1;
            while (left < right) {
                if (numbers[right] < 0) {
                    break;
                }
                if (numbers[left] + numbers[right] == target) {
                    res.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                    while(left < right && numbers[left] == numbers[++left]);
                    while(left < right && numbers[right] == numbers[--right]);
                } else if (numbers[left] + numbers[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
            while (i < n - 2 && numbers[i] == numbers[++i]);
        }
        return res;
    }
}