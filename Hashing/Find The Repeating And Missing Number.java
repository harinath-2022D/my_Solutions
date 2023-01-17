// Example 1
// Input

// 5
// 1 4 2 5 2
// Output

// 2 3
// Explanation

// We have, array: [1, 4, 2, 5, 2] and N = 5. In the given array ‘2’ occurs twice and the number ‘3’ is missing. Hence, we output 2 and 3 for the repeating and the missing number, respectively.
import java.util.*;

class Solution 
{
    static int[] findRepeatingAndMissingNumbers(int[] nums) 
    {
        //Write code here and print output
		// TC : O(N) , SC : O(1)
		int[] ans = new int[2];
		HashMap<Integer, Boolean> map = new HashMap<>();
		// repeating number
		for(int val : nums){
			if(map.get(val) == null){
				map.put(val, true);
			}
			else{
				ans[0] = val ;
			}
		}
		// missing number
		for(int i=1;i<=nums.length; i++){
			if(map.get(i) == null){
				ans[1] = i;
			}
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans = Solution.findRepeatingAndMissingNumbers(nums);
        System.out.print(ans[0] + " " + ans[1] + "\n");
    }
}
