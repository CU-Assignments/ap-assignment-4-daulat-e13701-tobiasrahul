class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1); 

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m, halfLen = (m + n + 1) / 2;

        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = halfLen - mid1;

            int left1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int right1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
            int left2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }
        return 0.0; 
    }
}
