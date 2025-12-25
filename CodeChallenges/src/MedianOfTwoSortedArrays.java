public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        // sorted arrays
        int[] nums1 = new int[]{1, 2, 6};
        int[] nums2 = new int[]{3, 4, 5};

        System.out.println(solution(nums1, nums2));
    }

    private static double solution(int[] nums1, int[] nums2) {
        int[] sortedArray = new int[nums1.length + nums2.length];
        /*for (int i = 0; i < nums1.length; i++) {
            sortedArray[i] = nums1[i];
        }
        for (int i = nums1.length; i < nums1.length + nums2.length; i++) {
            sortedArray[i] = nums2[i - nums1.length];
        }*/
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                sortedArray[k++] = nums1[i++];
            } else {
                sortedArray[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            sortedArray[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            sortedArray[k++] = nums2[j++];
        }
        int medianIndex = (sortedArray.length) / 2;
        double result;
        if (sortedArray.length % 2 == 0) {
            //even
            result = ((double) sortedArray[medianIndex - 1] + (double) sortedArray[medianIndex]) / 2;
        } else {
            //odd
            result = sortedArray[medianIndex];
        }
        return result;
    }


}
