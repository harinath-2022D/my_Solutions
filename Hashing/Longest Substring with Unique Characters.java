// Example 1
// Input

// xyzxyzyy
// Output

// 3
// Explanation

// The answer is "xyz ", with the length of 3
import java.util.*;

class Solution {
    public int longestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
		int start = 0;
		int len = 0;
		for(int i = 0; i < s.length(); i++){
			
			if(map.containsKey(s.charAt(i))){
				len = Math.max(start, len);
				start = Math.min(i -  map.get(s.charAt(i)) , start);
			}
			
			start++;
			map.put(s.charAt(i), i+1);
				
		}
		return Math.max(start, len);
    }
}

public class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        Solution ob = new Solution();
        int ans=ob.longestSubstring(s);
        System.out.println(ans);
    }
}
