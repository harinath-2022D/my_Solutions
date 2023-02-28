import java.util.*;

class Solution {
    public int maxOperations(int[] nums, int k) {
        //Write code here
		Arrays.sort(nums);
		int l = 0;
		int r = nums.length-1;
		int ans = 0;
		while(l<r){
			if(nums[l]+nums[r]==k){
				l++;
				r--;
				ans++;
			}else if(nums[l]+nums[r]>k){
				r--;
			}else{
				l++;
			}
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.maxOperations(arr, k);
        System.out.println(result);
        sc.close();
    }
}
