// d -> 21
// i -> 12
// ddd -> 4321
// iii -> 1234
// dddiddd -> 43218765
// iiddd -> 126543
import java.io.*;
import java.util.*;


class Solution{
    public String smallestNumber(String str){
        String ans = "";
		int num = 1;
		Stack<Integer> st = new Stack<>();

		for( int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);

			if( ch == 'd'){
				st.push(num);
				num++;
			}
			else{
				st.push(num);
				num++;

				while(st.size() > 0){
					ans+=st.pop();
				}
			}
		}
		st.push(num);
		while(st.size() > 0){
			ans+=st.pop();
		}
		return ans;
    }
}

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Solution Obj = new Solution();
    System.out.print(Obj.smallestNumber(str));
  }
}
