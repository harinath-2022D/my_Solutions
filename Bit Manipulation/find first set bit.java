import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        
        Solution obj=new Solution();
        int ans=obj.solve(n);
        System.out.println(ans);
    }
}

class Solution{
    
    static int solve(int n)
    {
          // Your code here
		int position = 1;
		int m = 1;
		while((n & m) == 0){
			m = m<<1;
			position++;
		}
       return position;
    }
}
