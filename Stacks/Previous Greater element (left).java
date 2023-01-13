// Input

// 4
// 10 20 30 40
// Output:

// -1 -1 -1 -1
// Explanation:

// For element 10 we not have any element in its left which is greater than 10, so we print -1, similary for 20, 30 and 40 no element is greater to the left of them.Therefore we print -1 -1 -1 -1.
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] prevGreater(long[] arr, int n)
    { 
		// tc O(N) sc O(N)
		long[] brr = new long[n];
        Stack<Long> st = new Stack<>();   
		brr[0] = -1;
		st.push(arr[0]);
		for(int i=1; i<n; i++){
			while(st.size()>0 && st.peek()<arr[i]){
				st.pop();
			}

			if(st.size() == 0){
				brr[i] = -1;
			}
			else{
				brr[i] = st.peek();
			}
			st.push(arr[i]);
		}
		return brr;
    } 
}
class Main {
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().prevGreater(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
	}
}
