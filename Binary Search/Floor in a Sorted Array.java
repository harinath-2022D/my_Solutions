import java.util.*;
import java.io.*;
class Solution{
	public static int findFloor(int[] arr, int x){
		int start = 0;
		int end = arr.length-1;
		int floor = -1;
		while(start<=end){
			int mid = (start+end)/2;
			if(arr[mid] == x){
				return mid;
			}
			else if(arr[mid]<x){
				floor = mid;
				start = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		return floor;
	}
}
public class Main {
    public static void main(String args[]) {
        //your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		Solution obj = new Solution();
		System.out.print(obj.findFloor(arr,target));
    }
}
