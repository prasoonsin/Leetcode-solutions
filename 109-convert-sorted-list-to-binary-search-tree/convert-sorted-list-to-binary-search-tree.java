class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();  
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        return createTree(arr, 0, arr.size() - 1);
    }
    public TreeNode createTree(ArrayList<Integer> arr, int left, int right) { 
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = createTree(arr, left, mid - 1);
        root.right = createTree(arr, mid + 1, right);
        
        return root;
    }
}