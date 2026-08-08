class Solution {
    void solve(List<List<Integer>>ans,List<Integer> curr,int i, int[] nums) {
        if(i>=nums.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j=0; j<curr.size(); j++)
            temp.add(curr.get(j));
            ans.add(temp);
            return;
        }
        curr.add(nums[i]);
        solve(ans,curr,i+1,nums);
        curr.remove(curr.size()-1);
        solve(ans,curr,i+1,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(ans,curr,0,nums);
        return ans;
    }

}