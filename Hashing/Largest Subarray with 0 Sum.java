
// EXAMPLE 1:
// Input:

// 8
// 15 -2  2 -8 1 7 10 23
// Output:

// 5
// Explanation:

// The longest sub-array with elements summing up-to 0 is {-2, 2, -8, 1, 7}
import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
   public int maxLen(int arr[])
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0,-1);
		int sum = 0;
		int maxlen = 0;
		for(int i=0; i<arr.length; i++){
			sum+=arr[i];
			
			if(map.containsKey(sum)){
				int len = i - map.get(sum);
				maxlen = Math.max(maxlen, len);
			}
			else{
				map.put(sum, i);
			}
		}
		return maxlen;
	}
}

class Main {
	
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution Obj = new Solution();
		System.out.println(Obj.maxLen(nums));
	}
}
