public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int i = 0;
        int tmp;
        for (int j = 1; j < A.length; j++) {
            if (A[j] != A[i]) {
                i++;
                if (i != j) {
                    tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
        return i + 1;
    }
}
