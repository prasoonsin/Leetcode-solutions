/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev = null;
    TreeNode newRoot = null;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return newRoot;
    }
    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (newRoot == null)
            newRoot = root;
        if (prev != null)
            prev.right = root;
        root.left = null;
        prev = root;
        inorder(root.right);
    }
}