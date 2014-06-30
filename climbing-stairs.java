public class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> cs = new HashMap();
        cs.put(0, 0);
        cs.put(1, 1);
        cs.put(2, 2);

        for (int i = 3; i <= n; i++) {
            int count = cs.get(i-1) + cs.get(i-2);
            cs.put(i, count);
        }
        return cs.get(n);
    }
}
