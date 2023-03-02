import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	   
        int n=sc.nextInt(); 
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            arr.add(x);
        }
        
        Solution ob=new Solution();
        System.out.println(ob.candies(arr,n));
        
	}
}


class Solution {
    public int candies(ArrayList<Integer> arr,int n) {
        //Write code here
		int[] candie = new int[n];
		Arrays.fill(candie,1);

		for(int i=1; i<n; i++){
			if(arr.get(i)>arr.get(i-1)){
				candie[i]=candie[i-1]+1;
			}
		}

		for(int i=n-2; i>=0; i--){
			if(arr.get(i)>arr.get(i+1)){
				candie[i]=Math.max(candie[i],candie[i+1]+1);
			}
		}

		int totalCandie = 0;
		for(int x : candie){
			totalCandie+=x;
		}

		return totalCandie;
	
    }
}
