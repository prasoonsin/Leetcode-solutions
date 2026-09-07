public class Codec {

    // Serialize: Tree → String
    public String serialize(TreeNode root) {

        if (root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder s = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {
                s.append("n ");
                continue;
            }

            s.append(node.val).append(" ");

            q.add(node.left);
            q.add(node.right);
        }

        return s.toString();
    }


    // Deserialize: String → Tree
    public TreeNode deserialize(String data) {

        if (data.equals(""))
            return null;

        String[] a = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(a[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            // Left child
            if (!a[i].equals("n")) {
                node.left = new TreeNode(Integer.parseInt(a[i]));
                q.add(node.left);
            }
            i++;

            // Right child
            if (!a[i].equals("n")) {
                node.right = new TreeNode(Integer.parseInt(a[i]));
                q.add(node.right);
            }
            i++;
        }

        return root;
    }
}