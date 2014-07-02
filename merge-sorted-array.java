public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[i + j + 1] = A[i];
                i--;
            } else {
                A[i + j + 1] = B[j];
                j--;
            }
        }
        for (;i>=0;i--) {
            A[i + j + 1] = A[i];
        }
        for (;j>=0;j--) {
            A[i + j + 1] = B[j];
        }        
    }
}
