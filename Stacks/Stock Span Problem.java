// Example 1
// Input

// 7
// 100 80 60 70 60 75 85
// Output

// 1 1 1 2 1 4 6
import java.io.*;
import java.util.*;

class Pair{
    int val;
    int idx;
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
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
        Solution s  = new Solution();
        int ans[] = s.stockSpan(a);
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    static int[] stockSpan(int[] a) {
		int len = a.length;
        int[] spans = new int[len];
		spans[0] = 1;
		Stack<Integer> st = new Stack<>();
		st.push(0);
		
		for(int i=1; i<len; i++){
			while(st.size()>0 && a[st.peek()] <= a[i]){
				st.pop();
			}

			if(st.size() == 0){
				spans[i] = i + 1;
			}
			else{
				spans[i] = i - st.peek();
			}

			st.push(i);
		}

		return spans;
    }
}
