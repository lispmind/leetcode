public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] ints = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] romans = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int i = 0;
        while (num > 0) {
            if (i != 0) {
                int maxLimit = ints[i - 1] + ints[i] * 4;
                int minLimit = ints[i] * 4;
                if (num >= maxLimit) {
                    sb.append(romans[i]);
                    sb.append(romans[i - 2]);
                    num -= (ints[i - 2] - ints[i]);
                    i += 2;
                    continue;
                } else if (num >= ints[i - 1]) {
                    sb.append(romans[i - 1]);
                    num -= ints[i - 1];
                } else if (num >= minLimit) {
                    sb.append(romans[i]);
                    sb.append(romans[i - 1]);
                    num -= (ints[i - 1] - ints[i]);
                }
            }
            int tmp = num / ints[i];
            for (; tmp > 0; tmp--) {
                sb.append(romans[i]);
                num -= ints[i];
            }
            i += 2;
        }
        return sb.toString();      
    }
}
