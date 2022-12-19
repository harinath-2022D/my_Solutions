// leetcode 40 :- https://leetcode.com/problems/combination-sum-ii/description/

// Q :- Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combination

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

class Solution {
    public void findingCombinations(int[] candidates, int sum,List<List<Integer>> ans,List<Integer> ds,int index){
        if(sum==0){// base condition
            ans.add(new ArrayList<>(ds));
            return;
        }
        // we have an option to pick any index of candidates array
        for(int i=index;i<candidates.length;i++){
            // if it is not a first index we don't want to pick' 
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>sum) break;
            ds.add(candidates[i]);
            findingCombinations(candidates,sum-candidates[i],ans,ds,i+1);
            ds.remove(ds.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // stores all the combinations
        List<List<Integer>> ans = new ArrayList<>();
        // sorting for avoiding duplicates
        Arrays.sort(candidates);
        List<Integer> ds = new ArrayList<>();
        findingCombinations(candidates,target,ans,ds,0);
        return ans;
    }
}
