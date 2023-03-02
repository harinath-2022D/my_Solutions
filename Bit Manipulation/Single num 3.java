import java.util.*;

class Solution {

    public int[] singleNumber3(int n, int[] nums) {
        // write code here
		int xarr=0;
		for(int e : nums){
			xarr=xarr^e;
		}

		int k = 0;
		while((xarr & 1<<k) == 0) k++;

		int havingKthBitSet = 0;
		int havingKthBitUnset = 0;
 
		for(int num : nums){
			if((num & 1<<k) > 0){
		      havingKthBitSet ^= num;
			}else{
				havingKthBitUnset ^= num;
			}
		}

		int[] ans = {havingKthBitUnset,havingKthBitSet};
		Arrays.sort(ans);
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}
