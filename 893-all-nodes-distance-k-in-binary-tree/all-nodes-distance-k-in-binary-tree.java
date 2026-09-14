/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // 1. Store parent of every node
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        makeParent(root, parent);

        // 2. BFS starting from target
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            if (distance == k)
                break;

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }

                // Right
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }

                // Parent
                TreeNode p = parent.get(node);

                if (p != null && !visited.contains(p)) {
                    visited.add(p);
                    q.add(p);
                }
            }

            distance++;
        }

        // 3. All nodes currently in queue are distance k
        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }


    // Create parent map
    void makeParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}