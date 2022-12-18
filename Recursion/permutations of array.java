// leet code 49 : https://leetcode.com/problems/permutations/description/

class Solution {
    public static void  printPermutations(int[] nums,List<List<Integer>> ans,List<Integer> ds,boolean fre[]){
        if(ds.size()==nums.length){ // base condition 
            // storing permutation in ans list
            ans.add(new ArrayList<>(ds));
            return;
        }
        // recursive call
        for(int i = 0; i < nums.length; i++){
            if(!fre[i]){
                fre[i] = true;// marking the value as taken
                ds.add(nums[i]); // adding value to ds
                printPermutations(nums,ans,ds,fre);
                ds.remove(ds.size()-1); // when come backing removeing value from ds
                fre[i] = false; // unmarking the value palce
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>(); // storing all permutations
       List<Integer> ds = new ArrayList<>(); // single permutations storing
       boolean fre[] = new boolean[nums.length]; // for marking element has been taken 
       printPermutations(nums,ans,ds,fre);
       return ans; 
    }
}
