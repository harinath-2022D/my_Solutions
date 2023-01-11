import java.io.*;
import java.util.*;

// Example 1
// Input

// 7 2
// 1 7 4 3 4 8 7
// Output

// 4
// Explanation

// As we traverse the array the first number whose frequency becomes greater than or equal to k(2) is 4. Hence, the answer is 4.
class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        
       HashMap<Integer, Integer> mymap = new HashMap<>();
		for(int key : nums){
			if(mymap.containsKey(key)){
				mymap.put(key,mymap.get(key)+1);
			}
			else{
				mymap.put(key,1);
			}
			if(mymap.get(key) == k){
				System.out.println(key);
				return;
			}
		}
		System.out.print(-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums,n,k);  
        System.out.println();
    }
}
