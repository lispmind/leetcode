public class Solution {
    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (high + low) >> 1;
            if (target == A[mid]) {
                return mid;
            } else if (target < A[mid]) {
                high = mid - 1;
            } else if (target > A[mid]) {
                low = mid + 1;
            }
        }
        return low;
    }
}
