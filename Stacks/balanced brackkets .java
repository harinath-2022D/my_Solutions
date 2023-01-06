
import java.util.*;

class Solution{
	public static String checkBalance(String str, int n){
		 Stack<Character> bracketStack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i);

      if (x == '{' || x == '[' || x == '(') {
        bracketStack.push(x);
        continue;
      }

      // Try to pop a matching bracket. If not found, it means
      // invalid expression
      if (bracketStack.isEmpty())
        return "NO";

      char poppedElement = bracketStack.pop();
      if (x == ']' && poppedElement != '[') return "NO";
      if (x == '}' && poppedElement != '{') return "NO";
      if (x == ')' && poppedElement != '(') return "NO";
    }

    return bracketStack.isEmpty() ? "YES" : "NO";
	}
    public void balancedBrackets(String str, int n) {
        // write code here
		System.out.print(checkBalance(str,n));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Solution Obj = new Solution();
        Obj.balancedBrackets(s, n);
    }
}
