import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.rowWithMaximumOnes(arr,n,m));
        
    }
}

class Solution {
	static int binarySearch(int[][] arr,int row){
		int lo = 0;
		int hi = arr[0].length-1;
		int firstIndexOf_1=arr[0].length;
		while(lo<=hi){
			int mid=(lo+hi)/2;
			if(arr[row][mid]==1){
				firstIndexOf_1=mid;
				hi = mid-1;
			}
			else{
				lo = mid+1;
			}
		}
		int count = arr[0].length-firstIndexOf_1;
		return count;
	}
    static int rowWithMaximumOnes(int arr[][], int n, int m) {
		int overAllMax1=0;
		int row = 0;
		for(int i=0;i<arr.length;i++){
			int rowWithMax_1s = binarySearch(arr,i);
			if(rowWithMax_1s>overAllMax1){
				overAllMax1 = rowWithMax_1s;
				row=i;
			}
		}
		return row;
    }
}
