class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        int lengthOfNums = nums.length;
        if (lengthOfNums == 1 && nums[0] == target) {
            return 0;
        } else if (lengthOfNums == 1) {
            return -1;
        }

        return index;
    }
}