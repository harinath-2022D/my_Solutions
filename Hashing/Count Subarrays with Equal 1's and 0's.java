// Example 1
// Input

// 3
// 1 0 1
// Output

// 2
// Explanation

// the subarrays from index 0 to 1 and 1 to 2 have equal number of 1's and 0's.
import java.util.*;

class Solution {
    static int countEqualSubarray01(int arr[], int n)
    {
        //Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0,1);
		int ans = 0;
		int sum = 0;
		for(int val : arr){
			if(val == 0){
				sum+= -1;
			}
			else{
				sum+= 1;
			}
			if(map.containsKey(sum)){
				ans+=map.get(sum);
				map.put(sum, map.get(sum)+1);
			}
			else{
				map.put(sum, 1);
			}
		}
		
		return ans;
         
    }   

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
    

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray01(arr,N));

    }
}
