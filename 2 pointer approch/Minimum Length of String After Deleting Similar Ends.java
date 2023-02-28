import java.util.*;

class Solution {
	static int solve(String s) {
		//Write your code here
		int len = s.length();
		int sp = 0;
		int ep = s.length() - 1;
		while(sp<ep){
			char c = s.charAt(sp);
			if(s.charAt(sp) == s.charAt(ep)){
				while(sp < ep && s.charAt(sp) == c){
					sp++;
					len--;
				}
				while(sp <= ep && s.charAt(ep) == c){
					ep--;
					len--;
				}
			}else{
				break;
			}
		}
		return len;
	}
}
public class Main{
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println(Solution.solve(s));
   }
}
