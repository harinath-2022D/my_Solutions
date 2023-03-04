import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	   public static void main(String args[]) {
		  
		   Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.numberOfSubstrings(s));
	    }
}
class Solution{
	   public static int numberOfSubstrings(String s) {
//your code
		   int[] freq = new int[3];
		   int sp =0;
		   int n = s.length();
		   int ans = 0;
		   
		   for( int ep = 0; ep < n; ep++){
			   freq[s.charAt(ep)-'a']++;

			   while(freq[0]>0 && freq[1]>0 && freq[2]>0){
				   ans += n-ep;
				   freq[s.charAt(sp++)-'a']--;
			   }
		   }

		   return ans;
}
}
