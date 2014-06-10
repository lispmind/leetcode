public class Solution {
    public int reverse(int x) {
        boolean neg = x < 0;
        x = neg ? -x : x;
        long r = 0;
        for (; x != 0; x /= 10) {
            r = 10 * r + x % 10;
        }
        if (r > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)(neg ? -r : r);
    }
}
