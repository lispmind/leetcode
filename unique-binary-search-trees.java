public class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            int mid = i / 2;
            for (int j = 1; j <= mid; j++) {
                nums[i] += nums[j-1] * nums[i-j];
            }
            nums[i] *= 2;
            if (i % 2 != 0) {
                nums[i] += nums[mid] * nums[mid];
            }
        }
        return nums[n];
    }
}
