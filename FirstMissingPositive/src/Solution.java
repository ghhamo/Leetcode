public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            while (num > 0 && num <= len) {
                int awaitedIndex = num - 1;
                int result = nums[awaitedIndex];
                nums[awaitedIndex] = num;
                if (result == num) {
                    break;
                } else {
                    num = result;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
