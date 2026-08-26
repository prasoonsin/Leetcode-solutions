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
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {

            Pair p = queue.remove();

            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }

            map.get(col).add(new int[]{row, node.val});

            if (node.left != null) {
                queue.add(new Pair(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, row + 1, col + 1));
            }
        }

        for (List<int[]> list : map.values()) {

            Collections.sort(list, (a, b) -> {

                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }

                return a[1] - b[1];
            });

            List<Integer> level = new ArrayList<>();

            for (int[] x : list) {
                level.add(x[1]);
            }

            ans.add(level);
        }

        return ans;
    }
}