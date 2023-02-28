import java.io.*;
import java.util.*;

class Solution {
    public static int longestUniqueSubsttr(String str)
    {
        // Your code here
		int n = str.length();
		if(n == 0) return 0;

		int sp = 0;
		int ep = 0;
		int ans = 0;
		int[] freq = new int[300];

		while(ep<n){
			freq[str.charAt(ep)]++;
			while(freq[str.charAt(ep)] > 1){
				freq[str.charAt(sp)]--;
				sp++;
			}
			ans = Math.max(ans,ep-sp+1);
			ep++;
		}

		return ans;
    }
}

public class Main {
     public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        int len = obj.longestUniqueSubsttr(str);
        System.out.println(len);
    }
}

