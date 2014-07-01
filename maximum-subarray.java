public class Solution {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < A.length; j++) {
            sum += A[j];
            if (sum >= max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
