public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> mp = new HashMap();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);

        Stack<Integer> sp = new Stack();
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int tmp = mp.get(s.charAt(i));
            if (sp.isEmpty()) {
                sp.push(tmp);
            } else {
                int head = sp.pop();
                if (tmp >= head) {
                    sp.push(head);
                    sp.push(tmp);
                } else {
                    res += head - tmp;
                }
            }
        }
        while (!sp.isEmpty()) {
            int head = sp.pop();
            res += head;
        }
        return res;
    }
}
