class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int current;
        int left = 0;
        int right = height.length - 1;
        while (left != right) {
            int arrL = height[left];
            int min = Math.min(arrL, height[right]);
            current = min * (right - left);
            if (min == arrL) {
                left++;
            } else {
                right--;
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}