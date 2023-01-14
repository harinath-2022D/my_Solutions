// Example 1
// Input

// 7
// 1 0 0 1 1 0 1
// 1
// Output

// 4
// Explanation

// After changing 6th integer in the array to 1, the array will become [1, 0, 0, 1, 1, 1, 1]. Length of longest subsegment of '1's is 4.
import java.util.*;

class Accio {
    public int longestOnes(int[] nums, int k) {
		// 2 pointers
         int count = 0;
		int ans =0;
		int j = -1;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				count++;
			}
			while(count>k){
				j++;
				if(nums[j]==0){
					count--;
				}
			}
			int len = i-j;
			if(len > ans){
				ans = len;
			}
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
    	for(int i=0;i<N;i++)
	    A[i] = sc.nextInt();
        int B = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.longestOnes(A, B));
    }
}
