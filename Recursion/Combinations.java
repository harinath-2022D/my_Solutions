//leetcode 77 : https://leetcode.com/problems/combinations/description/
// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

class Solution {
    public static void solve(int n, int k, int start,List<List<Integer>> ans, List<Integer> temp){
        if(k==0){// base case
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(n<0) return;
        for(int i=start; i<=n-k+1; i++){ // i<=n also work
            temp.add(i);
            solve(n,k-1,i+1,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        // storing all combinations
        List<List<Integer>> ans = new ArrayList<>();
        // storing each combination
        List<Integer> temp = new ArrayList<>();
        solve(n,k,1,ans,temp);
        return ans;
    }
}
