import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] candidates, int target,
                           List<Integer> curr, List<List<Integer>> ans) {

    
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

  
        if (target < 0) return;

    
        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            backtrack(i, candidates, target - candidates[i], curr, ans); 
            curr.remove(curr.size() - 1); 
        }
    }
}
