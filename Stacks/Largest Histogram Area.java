// Example 1
// Input

// 4
// 1 2 3 1
// Output

// 4
// Explanation

// The rectangle 1 1 1 1 is maximum possible.

// Height = 1. Width is 1 * 4 = 4.

// Area = 1 * 4 = 4.
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
	}
}

class Solution
{
	public static long[] nextSmallerOnLeftidx(long hist[],int n){
		long[] arr = new long[n];
		Stack<Integer> st = new Stack<>();
		for(int i = n-1; i >= 0; i--){
			while(st.size()>0 && hist[i] < hist[st.peek()]){
				arr[st.peek()] = i;
				st.pop();
			}
			st.push(i);
		}
		while(st.size()>0){
			arr[st.peek()] = -1;
			st.pop();
		}
		return arr;
	}

	public static long[] nextSmallerOnRightidx(long[] hist, int n){
		long[] arr = new long[n];
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<n;i++){
			while(st.size()>0 && hist[i]<hist[st.peek()]){
				arr[st.peek()] = i;
				st.pop();
			}
			st.push(i);
		}
		while(st.size()>0){
			arr[st.peek()] = n;
			st.pop();
		}
		return arr;
	}
      public static long maximumArea(long hist[], long n){
	      long left[] = nextSmallerOnLeftidx(hist,(int) n);
		  long right[] = nextSmallerOnRightidx(hist, (int) n);
		  long ans = 0;
		  for(int i=0;i<n;i++){
			  long area = hist[i]*(right[i]-left[i]-1);
			  ans = Math.max(ans,area);
		  }
		  return ans;
    }
}
