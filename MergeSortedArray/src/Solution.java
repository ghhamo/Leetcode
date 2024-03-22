class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0 || m <= 0) return;
        if (nums1[m-1] <= nums2[0]) {
            System.arraycopy(nums2, 0, nums1 , m, n);
        }
    }
}
/*
1 2 3
2 4 6
*/