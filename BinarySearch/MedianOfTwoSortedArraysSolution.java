public class MedianOfTwoSortedArraysSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = nums1.length;

        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = ((x + y + 1) / 2) - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == nums1.length) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == nums2.length) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && minRightX >= maxLeftY) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) (Math.max(maxLeftX, maxLeftY));
                }

            }
            if (maxLeftX > minRightY) {
                end = partitionX - 1;
            } else if (minRightX < maxLeftY) {
                start = partitionX + 1;
            }
        }

        return -1;
    }
}
