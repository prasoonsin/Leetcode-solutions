class Solution {

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Go left
        inorder(root.left);

        // Process current node
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }

        prev = root.val;

        // Go right
        inorder(root.right);
    }
}