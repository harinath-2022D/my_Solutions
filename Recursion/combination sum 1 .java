// https://leetcode.com/problems/combination-sum/description/

// Q :- Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.
  
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

class Solution {
    public void findingCombinations(int[] candidates, int sum,List<List<Integer>> ans,List<Integer> ds,int index){
        // base condition
        if(index==candidates.length){
        if(sum==0){
            ans.add(new ArrayList<>(ds));
        }
            return;
        }
           // recursive condition 
        if(candidates[index]<=sum){
            ds.add(candidates[index]);
            // we are not changing the index still picking the same index value of candidates
            findingCombinations(candidates,sum-candidates[index],ans,ds,index);
            // when ever come backing case wwe need to remove last elment to achieve target
            ds.remove(ds.size()-1);
        }
        // changing index value and picking other element
        findingCombinations(candidates,sum,ans,ds,index+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findingCombinations(candidates,target,ans,ds,0);
        return ans;
    }
}
