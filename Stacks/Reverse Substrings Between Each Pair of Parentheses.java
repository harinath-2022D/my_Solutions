// Example 2
// Input

// (accio(job))
// Output

//  joboicca
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(reverseParentheses(s));
  }

  public static String reverseParentheses(String s) {
    // your code here
	  Stack<String> st = new Stack<>();

	  int i = 0;
	  while(i<s.length()){
		  if(s.charAt(i)!=')'){
			  st.push(s.charAt(i)+"");
		  }
		  else{
			  StringBuilder sb = new StringBuilder();
			  while(st.size()>0 && !st.peek().equals("(") ){
				  sb.append(st.pop());
			  }

			  st.pop();
			  st.push(sb.reverse().toString());
		  }
		  i++;
	  }
	  StringBuilder ans = new StringBuilder();
	  while(st.size()>0){
		  ans.append(st.pop());
	  }
	  return ans.reverse().toString();
  }
}
