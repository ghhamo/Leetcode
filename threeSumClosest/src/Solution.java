import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.parallelSort(numbers);
        int n = numbers.length;
        int i = 0;
        int interval;
        int closest = numbers[0] + numbers[1] + numbers[n - 1];
        int closestInterval = Math.abs(target - closest);

        while (i < n - 2) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int result = numbers[i] + numbers[right] + numbers[left];
                if (result < target) {
                    interval = target - result;
                } else if (result > target) {
                    interval = result - target;
                } else {
                    return target;
                }
                if (interval < closestInterval) {
                    closest = result;
                    closestInterval = interval;
                }
                if (result > target) {
                    right--;
                } else {
                    left++;
                }
            }
            while (i < n - 2 && numbers[i] == numbers[++i]) ;
        }
        return closest;
    }
}