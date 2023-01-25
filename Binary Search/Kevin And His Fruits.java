// Example 1
// Input

// 4 30
// 10 40 30 20
// Output

// 20
// Explanation

// If we set the marker at 20 then Kevin can eat following fruits from each bucket: 0 (1st bucket) + 20 (2nd bucket) + 10 (3rd bucket) + 0 (4th bucket) = 30 (K).
import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            arr.add(sc.nextInt());
        }
        int ans = Solution.getMaxMarker(arr, n, m);
        System.out.println(ans);
    }
}
class Solution 
{
	static boolean isPossible(ArrayList<Integer> arr, int m, int mid){
		int sum = 0;
		for(int i = 0; i < arr.size(); i++){
			int ele = arr.get(i);
			if(ele>mid){
				sum+=ele-mid;
			}
			if(sum>=m) return true;
		}
		return false;
	}
    static int getMaxMarker(ArrayList<Integer> arr, int n, int m) 
    {
       int lo = 0;
	   int hi = 0;
		for(int val : arr){
			hi = Math.max(hi,val);
		}
		int ans = -1;
		while(lo<=hi){
			int mid = (lo+hi)/2;
			if(isPossible(arr,m,mid)){
				ans = mid;
				lo = mid+1;
			}else{
				hi = mid-1;
			}
		}
		return ans;
    }
}
