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
    public int amountOfTime(TreeNode root,int start) {
        HashMap<TreeNode,TreeNode> parent=new HashMap<>();
        TreeNode target=findParent(root,start,parent);
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> vis=new HashSet<>();
        q.add(target);
        vis.add(target);
        int time=0;
        
        while(!q.isEmpty()) {
            int size=q.size();
            boolean burned=false;
            
            for(int i=0;i<size;i++) {
                TreeNode node=q.remove();
                
                if(node.left!=null&&!vis.contains(node.left)) {
                    q.add(node.left);
                    vis.add(node.left);
                    burned=true;
                }
                
                if(node.right!=null&&!vis.contains(node.right)) {
                    q.add(node.right);
                    vis.add(node.right);
                    burned=true;
                }
                
                if(parent.containsKey(node)&&!vis.contains(parent.get(node))) {
                    q.add(parent.get(node));
                    vis.add(parent.get(node));
                    burned=true;
                }
            }
            
            if(burned) time++;
        }
        
        return time;
    }
    
    private TreeNode findParent(TreeNode root,int start,HashMap<TreeNode,TreeNode> parent) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode target=null;
        
        while(!q.isEmpty()) {
            TreeNode node=q.remove();
            
            if(node.val==start) target=node;
            
            if(node.left!=null) {
                parent.put(node.left,node);
                q.add(node.left);
            }
            
            if(node.right!=null) {
                parent.put(node.right,node);
                q.add(node.right);
            }
        }
        
        return target;
    }
}