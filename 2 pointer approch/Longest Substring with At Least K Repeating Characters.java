import java.util.*;

class Solution {
	public int helper(String s){
		int count = 0;
		int[] arr = new int[256];
		for(int i=0; i<s.length(); i++){
			int idx = s.charAt(i)-'a';
			arr[idx]++;
		}
		for(int i=0; i<256; i++){
			if(arr[i] >=1 ){
				count++;
			}
		}
		return count;
	}
    public int longestSubstring(String s, int k) {
        // write code here
		int ans = 0;
		char[] str = s.toCharArray();
		int maxUnique = helper(s);

		for(int currUniq = 1; currUniq <= maxUnique; currUniq++){
    		int[] freq = new int[26];
			int sp = 0;
			int ep = 0;
			int uniq = 0;
			int atLeastK = 0;
			while(ep < str.length){
				// expanding window
				if(uniq <= currUniq){
					int idx = str[ep]-'a';
					if(freq[idx] == 0) uniq++;
					freq[idx]++;
					if(freq[idx] == k) atLeastK++;
					ep++;
				}else{// shrinking window
					int idx = str[sp]-'a';
					if(freq[idx] == k) atLeastK--;
					freq[idx]--;
					if(freq[idx] == 0) uniq--;
					sp++;
				}
				if(uniq == currUniq && uniq == atLeastK){
					
					ans = Math.max(ans,ep-sp);
				}
			}
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
