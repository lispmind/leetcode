public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outs = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                outs.add(Arrays.asList(1));
            } else {
                List<Integer> pre = outs.get(i - 1);
                List<Integer> cur = new ArrayList<Integer>();
                for (int j = 0; j < i + 1; j++) {
                    int tmp = (j >= i ? 0 : pre.get(j)) + (j <= 0 ? 0 : pre.get(j - 1));
                    cur.add(tmp);
                }
                outs.add(cur);
            }
        }
        return outs;
    }
}
