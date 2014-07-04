public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> grays = new ArrayList();
        grays.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = grays.size() - 1; j >= 0; j--) {
                grays.add(grays.get(j) + (1 << i));
            }
        }
        return grays;
   }
}
