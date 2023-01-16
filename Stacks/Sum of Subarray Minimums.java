// Example 1
// Input

// 4
// 3 1 2 4
// Output

// 17
// Explanation

// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
import java.io.*;
import java.util.*;

class Solution{
public static int[] nextSmallerOnLeftIdx(int[] arr, int n)
{ 
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>(); 
	
    for(int i = n - 1; i >= 0; i--) {
    	while(st.size() > 0 && arr[i] < arr[st.peek()]) {
    		ans[st.peek()] = i;
    		st.pop();
    	}
    	st.push(i);
    }
    
    while(st.size() > 0) {
    	ans[st.peek()] = -1;
    	st.pop();
    }
    return ans;
}

public static int[] nextSmallerOnRightIdx(int[] arr, int n) { 
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>(); 
	
    for(int i = 0; i < n; i++) {
    	while(st.size() > 0 && arr[i] <= arr[st.peek()]) {
    		ans[st.peek()] = i;
    		st.pop();
    	}
    	st.push(i);
    }
    
    while(st.size() > 0) {
    	ans[st.peek()] = n;
    	st.pop();
    }
    return ans;
}

	public long minSubarraySum(int n, int a[]){
		int[] nsl = nextSmallerOnLeftIdx(a, n);
	int[] nsr = nextSmallerOnRightIdx(a, n);
	long ans = 0;
	long M = 1000000007;
	
	 // (a + b) % M
	// => ((a % M) + (b % M)) % M
	
	for(int i = 0; i < n; i++) {
		long num = (long)(i - nsl[i]) * (long)(nsr[i] - i);
		long temp = (num % M * a[i] % M) % M;
		ans = (ans % M + temp % M) % M;
	}
	
	return ans;
	}
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
		Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n,a));
    }
}
