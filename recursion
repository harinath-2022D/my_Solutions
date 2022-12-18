import java.io.*;
import java.util.*;
class Solution{

	public static void generateAllParanthesis(int n,int open,int close,String str,ArrayList<String> ans){
		if(open==n && close==n){
			ans.add(str);
			return;
		}
		if(open<n){
			generateAllParanthesis(n,open+1,close,str+'(',ans);
		}
		if(close<open){
			generateAllParanthesis(n,open,close+1,str+')',ans);
		}
	}
     public static void generateParanthesis(int n){
        
		 ArrayList<String> ans = new ArrayList<>();
		 generateAllParanthesis(n,0,0,"",ans);
		 Collections.sort(ans);
		 for(int i=0;i<ans.size();i++){
			 System.out.println(ans.get(i));
		 }
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Solution obj=new Solution();
        obj.generateParanthesis(n);
    }
}
