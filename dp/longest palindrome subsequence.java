
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
	// recursive top down approch dp
	// time complexity = o(n^2)
	// space complexity = o(n^2)
	public static int solve(int s, int e, char[] arr, int[][] dp){
		if(s==e) return 1;
		if(s>e) return 0;
		if(dp[s][e]!=0) return dp[s][e];

		if(arr[s]==arr[e]) return 2+solve(s+1,e-1,arr,dp);
		int leave_left = solve(s+1,e,arr,dp);
		int leave_rigth = solve(s,e-1,arr,dp);
		dp[s][e] = Math.max(leave_left,leave_rigth);
		return dp[s][e];
	}
    public static int longestPalindromeSubseq(String s) 
    {
        //Write your code here
		int n = s.length();
		int[][] dp = new int[n][n];
		char[] arr = s.toCharArray();
		int ans = solve(0,n-1,arr,dp);
		return ans;
    }
    
    
}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.print(Solution.longestPalindromeSubseq(s));

	}
}

