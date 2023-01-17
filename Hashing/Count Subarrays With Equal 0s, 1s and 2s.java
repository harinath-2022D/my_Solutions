// Example 1
// Input

// 4
// 2 0 1 2
// Output

// 2
// Explanation

//  the subarrays from index 0 to 2 and 1 to 3 have equal number of 0's,1's and 2's.
import java.util.*;

class Solution {
    static int countEqualSubarray012(int arr[], int n)
    {
        //Write your code here
		int ans = 0;
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
		String key = (c1-c0) +"#"+ (c2-c1);
		HashMap<String, Integer> map = new HashMap<>();
		map.put(key, 1);
		for(int val : arr){
			if(val == 0){
				c0++;
			}
			else if(val == 1){
				c1++;
			}
			else{
				c2++;
			}
			key = (c1-c0) +"#"+ (c2-c1);
			if(map.containsKey(key)){
				ans+=map.get(key);
				map.put(key, map.get(key)+1);
			}
			else{
				map.put(key, 1);
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
        System.out.println(Obj.countEqualSubarray012(arr,N));

    }
}
