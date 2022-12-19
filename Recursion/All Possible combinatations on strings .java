// https://course.acciojob.com/idle?question=2a7c2453-9ad8-4b8a-a776-06bb9ba556cc
// sample input :-
//              2
//              ab cd
//       output :-
//              ac ad bc bd


import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
	public static void solve(ArrayList<String> st,ArrayList<String> ans, int index,int n,String str){
		if(index==n){
			ans.add(str);
			return;
		}
		String req = st.get(index);
		for(int i=0;i<req.length();i++){
			solve(st,ans,index+1,n,str+req.charAt(i));
		}
	}
	public static ArrayList<String> specialStrings(ArrayList<String> st,int n){
		ArrayList<String> ans = new ArrayList<>();
		solve(st,ans,0,n,"");
		return ans;
	}
}
class Main {
	
  
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    	int n = sc.nextInt();
			ArrayList<String> A = new ArrayList<String>();
			for(int i=0;i<n;i++)
			{
				A.add(sc.next());
			}
            ArrayList<String> ans=new ArrayList<String>();
            Solution obj=new Solution();
            ans=obj.specialStrings(A,n);
			Collections.sort(ans);
	    	for(int i = 0; i < ans.size(); i++) {   
				System.out.print(ans.get(i)+" ");
			}  
		
	}
}

