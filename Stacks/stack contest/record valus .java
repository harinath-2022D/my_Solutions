
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String operation[]=new String[n];
        for(int i=0;i<n;i++)
        operation[i]=sc.next();
        
        Solution obj=new Solution();

        System.out.println(obj.solve(operation,n));

		sc.close();
    }
}

class Solution {

    int solve(String str[],int n) {
        // Add your code here.
		Stack<Integer> st = new Stack<>();
		for(int i=0; i<str.length; i++){
			if(str[i].equals("+")){
				int last = st.pop();
				int next = last + st.peek();
				st.push(last);
				st.push(next);
			}
			else if(str[i].equals("C")){
				st.pop();
			}
			else if(str[i].equals("D")){
				st.push(2*st.peek());
			}
			else{
				st.push(Integer.parseInt(str[i]));
			}
		}
		int sum = 0;
		while(!st.empty()){
			sum+=st.pop();
		}
		return sum;
    
  }
}
