import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int bulbs(int[] A) {
        // your code here
		int cnt = 0;
		for(int i=0; i<A.length; i++){
			if(A[i] == 0 && cnt%2 == 0){
				cnt++;
			}else if(A[i] == 1 && cnt%2 != 0){
				cnt++;
			}
		}
		return cnt;
    }
}

public class Main {
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    	int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0;i<n;i++)
			{
				A[i]= sc.nextInt();
			}
            Solution solution = new Solution();
	    	System.out.println(solution.bulbs(A));
		
	}
}
