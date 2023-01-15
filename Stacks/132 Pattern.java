// Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

// Return true if there is a 132 pattern in nums, otherwise, return false.
//   Example 3
// Input

// 4
// -1 3 2 0
// Output

// true
// Explanation

// There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
		int secondMax = Integer.MIN_VALUE;

		for(int i=nums.length-1; i>=0; i--){
			if(nums[i] < secondMax){
				return true;
			}
			while(st.size()>0 && nums[i]>st.peek()){
				secondMax = Math.max(secondMax, st.pop());
			}
			st.push(nums[i]);
		}
		return false;
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
        Solution Obj = new Solution();
        boolean result = Obj.find132pattern(arr);
        if (result)
            System.out.println("true");
        else
            System.out.println("false");
        sc.close();
    }
}
  
