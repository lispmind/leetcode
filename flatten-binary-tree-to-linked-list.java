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
    public void flatten(TreeNode root) {
        if (root != null) {
            TreeNode head = new TreeNode(0);
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                head.right = tmp;
                head = head.right;
                if (tmp.right != null) {
                    stack.push(tmp.right);
                    tmp.right = null;
                }
                if (tmp.left != null) {
                    stack.push(tmp.left);
                    tmp.left = null;
                }
            }
        }
    }
}
