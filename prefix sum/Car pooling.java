
 import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
//your code
		int[] stops = new int[1001];
		for(int i=0; i<trips.length; i++){
			int passengers = trips[i][0];
			int sp = trips[i][1];
			int ep = trips[i][2];
			stops[sp]+=passengers;
			stops[ep+1]-=passengers;
		}
		for(int j=1;j<1001;j++){
			stops[j]+=stops[j-1];
		}
		for(int k=1;k<1001;k++){
			if(stops[k]>capacity){
				return false;
			}
		}
		return true;
}
}
