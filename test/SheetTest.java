import sun.management.resources.agent;

import java.util.*;

public class SheetTest {

    public static int singleNumber(int[] A) {
//        int k = 3;
//        int l = 1;
//        int[] c = new int[32];
//        for (int a : A) {
//            for (int i = 0; i < 32; i++) {
//                c[i] = (c[i] + a & 0x00000001) % 3;
//                a = a >> 1;
//            }
//        }
//        int res = 0, base = 1;
//        for (int i = 0; i < 32; i++) {
//            res += (base * c[i]);
//            base <<= 1;
//        }
//        System.out.println(res);
//        return 1;

        int k = 3;
        int l = 1;
        if (A == null) return 0;
        int t;
        int[] x = new int[k];
        x[0] = ~0;
        for (int i = 0; i < A.length; i++) {
            t = x[k - 1];
            for (int j = k - 1; j > 0; j--) {
                x[j] = (x[j - 1] & A[i]) | (x[j] & ~A[i]);
            }
            x[0] = (t & A[i]) | (x[0] & ~A[i]);
        }
        System.out.println(x[l]);
        return x[l];
    }

    public static int romanToInt(String s) {
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
        // MMMCMXCIX

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

    public static int climbStairs(int n) {
        Map<Integer, Integer> cs = new HashMap();
        cs.put(0, 0);
        cs.put(1, 1);
        cs.put(2, 2);

        for (int i = 3; i <= n; i++) {
            int count = cs.get(i - 1) + cs.get(i - 2);
            cs.put(i, count);
        }
        return cs.get(n);
    }

    public static int maxSubArray(Integer[] A) {
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

    public static String intToRoman(int num) {
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

    public static int removeElement(Integer[] A, int elem) {
//        int num = 0;
//        int i = 0, j = A.length - 1;
//        while (i <= j) {
//            if (A[i] != elem) {
//                num++;
//                i++;
//                continue;
//            }
//            if (A[j] == elem) {
//                j--;
//                continue;
//            }
//            if (A[i] == elem && A[j] != elem) {
//                num++;
//                A[i] = A[j];
//                i++;
//                j--;
//            }
//        }
//        return num;

        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[k++] = A[i];
            }
        }
        return k;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return (left != -1 && right != -1 && Math.abs(left - right) <= 1) ? 1 + Math.max(left, right) : -1;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        for (ListNode cur = temp; cur.next != null && cur.next.next != null; cur = cur.next.next) {
            cur.next = swap(cur.next, cur.next.next);
        }
        return temp.next;
    }

    private static ListNode swap(ListNode first, ListNode second) {
        first.next = second.next;
        second.next = first;
        return second;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        return makeTree(num, 0, num.length - 1);
    }

    public TreeNode makeTree(int[] num, int start, int end) {
        if (end < start) {
            return null;
        } else if (end == start) {
            return new TreeNode(num[start]);
        } else {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = makeTree(num, start, mid - 1);
            root.right = makeTree(num, mid + 1, end);
            return root;
        }
    }

    public int removeDuplicates(Integer[] A) {
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

    public void merge(Integer A[], int m, Integer B[], int n) {
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

    public int[] grayCodeArray(int n) {
        int[] grays = new int[n << 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                grays[0] = 0;
                grays[1] = 1;
            } else {
                for (int j = 0; j < (i - 1) << 1; j++) {
                    grays[(i << 1) - j - 1] = (grays[j] << 1) + 1;
                    grays[j] = grays[j] << 1;
                }
            }
        }
        return grays;
    }

    public List<Integer> grayCode3(int n) {
        List<Integer> grays = new ArrayList();
        for (int i = 0; i < Math.pow(2, n); i++) {
            grays.add(0);
        }
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                grays.set(0, 0);
                grays.set(1, 1);
            } else {
                int len = (int) Math.pow(2, i - 1);
                for (int j = 0; j < len; j++) {
                    grays.set((len << 1) - 1 - j, (grays.get(j) << 1) + 1);
                    grays.set(j, grays.get(j) << 1);
                }
            }
        }
        return grays;
    }

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

    public static int bsearch(int[] A, int k) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == k) {
                return mid;
            } else if (A[mid] < k) {
                low = mid + 1;
            } else if (A[mid] > k) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void qsort(int[] A) {
        qsort(A, 0, A.length - 1);
    }

    public static void qsort(int[] A, int low, int high) {
        if (low < high) {
            int i = low;
            int j = high;
            int k = A[i];
            while (i < j) {
                while (i < j && A[j] > k) {
                    j--;
                }
                if (i < j) {
                    A[i++] = A[j];
                }
                while (i < j && A[i] < k) {
                    i++;
                }
                if (i < j) {
                    A[j--] = A[i];
                }
            }
            A[i] = k;
            qsort(A, low, i - 1);
            qsort(A, i + 1, high);
        }
    }

    public static int[] rand(int len) {
        int[] x = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            x[i] = random.nextInt(len);
        }
        return x;
    }

    public static void print(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + ",");
        }
        System.out.println("");
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (true) {
            if (slow != null && slow.next != null) {
                slow = slow.next;
            } else {
                return null;
            }
            if (fast != null && fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
//        int[] x = rand(10);
//        print(x);
//        qsort(x);
//        print(x);
//        int k = new Random().nextInt(x.length - 1);
//        System.out.println("found " + x[k] + " in " + bsearch(x, x[k]) + " for " + k);

//        System.out.println("Aa".hashCode());
//        System.out.println("BB".hashCode());
//        System.out.println(new SheetTest().grayCode(4));
//        new SheetTest().grayCode(3).add(33);
//        new SheetTest().grayCodeArray(2);

//        System.out.println(new SheetTest().generate(5));

//        Integer[] a = Arrays.asList(-2, -1, -1, 1, 2, 3, 2, 3, 4).toArray(new Integer[]{});
//        Integer[] b = Arrays.asList(-1, 1, 3).toArray(new Integer[]{});
//        Integer[] a = Arrays.asList(0).toArray(new Integer[]{});
//        Integer[] b = Arrays.asList(1).toArray(new Integer[]{});
//        new SheetTest().merge(a, 0, b, 1);
//        System.out.println(Arrays.asList(a));

//        Integer[] a = Arrays.asList(-2, -1, -1, 0, 1, 1, 2, 3, 4).toArray(new Integer[]{});
//        Integer[] a = Arrays.asList(1).toArray(new Integer[]{});
//        Integer[] a = Arrays.asList().toArray(new Integer[]{});
//        System.out.println(new SheetTest().removeDuplicates(a));
//        System.out.println(Arrays.asList(a));

//        ListNode n1 = new ListNode(1);
//        n1.next = new ListNode(2);
//        n1.next.next = null;
//        ListNode o1 = swapPairs(n1);
//        while (o1 != null) {
//            System.out.println(o1.val);
//            o1 = o1.next;
//        }

//        Integer[] a = Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4).toArray(new Integer[]{});
//        Integer[] a = Arrays.asList(1, 1).toArray(new Integer[]{});
//        Integer[] a = Arrays.asList(1).toArray(new Integer[]{});
//        System.out.println(removeElement(a, 1));
//        System.out.println(Arrays.asList(a));

//        System.out.println(intToRoman(3999));
//        System.out.println(intToRoman(3996));
//        System.out.println(intToRoman(3949));
//        System.out.println(intToRoman(3944));
//        System.out.println(intToRoman(3499));
//        System.out.println(intToRoman(3449));
//        System.out.println(intToRoman(3444));
//        System.out.println(intToRoman(1));
//        System.out.println(intToRoman(7));
//        System.out.println(intToRoman(4));

//        Integer[] a = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4).toArray(new Integer[]{});
//        Integer[] a = Arrays.asList(-2).toArray(new Integer[]{});
//        Integer[] a = Arrays.asList(-2,-3,2,-4,-1).toArray(new Integer[]{});
//        Integer[] a = Arrays.asList(-2,-3,-4,-1).toArray(new Integer[]{});
//        System.out.println(maxSubArray(a));

//        System.out.println(climbStairs(3));
//        System.out.println(climbStairs(4));
//        System.out.println(climbStairs(5));
//        System.out.println(climbStairs(10));

//        System.out.println(romanToInt("MCMXLVI"));
//        System.out.println(romanToInt("MCMXLVIII"));
//        System.out.println(romanToInt("DCCC"));
//        System.out.println(romanToInt("CD"));
//        System.out.println(romanToInt("CM"));
//        System.out.println(romanToInt("MMMCMXCIX"));

//        System.out.println(~0);
//        singleNumber(new int[]{1, 1, 1, 3, 3, 3, -2});
//        singleNumber(new int[]{1, 1, 1, 3, 3, 3, 2});
    }
}
