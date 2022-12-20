// https://leetcode.com/problems/climbing-stairs/submissions/862520688/

class Solution {
    private int distinctWayToClimbStairs(int n, int[] arr){
        if(n < 0){
            return 0;
        }
        if(n == 0) {
			return 1;
		}
        if(arr[n] > 0){
            return arr[n];
        }
        int ways = distinctWayToClimbStairs(n - 1, arr) + distinctWayToClimbStairs(n - 2, arr);
        arr[n] = ways;
        return ways;
    }
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        return distinctWayToClimbStairs(n,arr);
    }
}
