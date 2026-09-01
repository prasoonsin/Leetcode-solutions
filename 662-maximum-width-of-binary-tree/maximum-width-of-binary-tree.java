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
    class Pair {
        TreeNode node;
        long index;
        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            long first = q.peek().index;
            long last = first;

            for(int i = 0; i < size; i++) {
                Pair p = q.remove();
                TreeNode node = p.node;
                long index = p.index;

                last = index;

                if(node.left != null)
                    q.add(new Pair(node.left, 2 * index + 1));

                if(node.right != null)
                    q.add(new Pair(node.right, 2 * index + 2));
            }

            ans = Math.max(ans, (int)(last - first + 1));
        }
        return ans;
    }
}