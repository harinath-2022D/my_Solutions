// Input

// [(a+b)+{(c+d)*(e/f)}]
// Output

// true
import java.io.*;
import java.util.*;

class Solution{
	static char open(char ch){
		if(ch == ')') return '(';
		else if(ch == '}') return '{';
		else return '[';
	}
    boolean expBalanced(String str){
        Stack<Character> st = new Stack<>();
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch == '(' || ch == '{' || ch == '['){
				st.push(ch);
			}
			else if(ch == ')' || ch == '}' || ch == ']'){
				if(st.size()>0 && st.peek() == open(ch)){
					st.pop();
				}
				else {
					
					return false;
				}
			}
		}
		return (st.size() == 0);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.println(Obj.expBalanced(str));
    }
}
