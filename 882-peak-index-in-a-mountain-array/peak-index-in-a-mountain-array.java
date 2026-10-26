class Solution {

    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {

                // Uphill → peak is on the right
                left = mid + 1;

            } else {

                // Downhill → mid may be the peak
                right = mid;
            }
        }

        return left;
    }
}