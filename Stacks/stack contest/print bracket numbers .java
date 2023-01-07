
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.barcketNumbers(S);
            for(int value :  result)
            System.out.print(value + " ");
            System.out.println();
        
    }
}


class Solution {
	public static void findBracketPattern(String str, ArrayList<Integer> ans){
		Stack<Integer> st = new Stack<>();
		int count = 1;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i)  == '('){
				ans.add(count);
				st.push(count);
				count++;
			}
			else if(str.charAt(i) == ')'){
				ans.add(st.peek());
				st.pop();
			}
		}
	}
    ArrayList<Integer> barcketNumbers(String s) {
        // code here
		ArrayList<Integer> ans = new ArrayList<>();
		findBracketPattern(s,ans);
		return ans;
    }
};
