// leet code 49 : https://leetcode.com/problems/permutations/description/
// approch 1:
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


// Best approch 2:
class Solution{ 
    public void recuPermute(int index,int[] nums,List<List<Integer>> ans){
        if(index==num.length){
            // copy the ds into ans
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = index; i<nums.length; i++){
            swap(i, index, nums);
            recuPermute(index+1, nums, ans);
            swap(i, index, nums);
        }
    }
    
    public static void swap(int i, int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new arrayList<>();
        recuPermute(0, nums, ans);
        return ans;
    }
}
