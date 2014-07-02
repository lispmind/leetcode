/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
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
}
