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
    public TreeNode constructFromPrePost(int[] preorder,int[] postorder) {
        return build(preorder,postorder,0,0,preorder.length);
    }

    TreeNode build(int[] pre,int[] post,int ps,int pos,int n) {
        if(n==0) return null;

        TreeNode root=new TreeNode(pre[ps]);

        if(n==1) return root;

        int leftRoot=pre[ps+1];
        int i=pos;

        while(post[i]!=leftRoot) i++;

        int leftSize=i-pos+1;

        root.left=build(pre,post,ps+1,pos,leftSize);
        root.right=build(pre,post,ps+leftSize+1,i+1,n-leftSize-1);

        return root;
    }
}