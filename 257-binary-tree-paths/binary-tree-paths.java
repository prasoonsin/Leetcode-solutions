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
class Solution{
    void path(TreeNode root,String s,List<String> ans){
        if(root==null)return;
        s+=root.val;
        if(root.left==null&&root.right==null){
            ans.add(s);
            return;
        }
        s+="->";
        path(root.left,s,ans);
        path(root.right,s,ans);
    }
    public List<String> binaryTreePaths(TreeNode root){
        List<String> ans=new ArrayList<>();
        path(root,"",ans);
        return ans;
    }
}