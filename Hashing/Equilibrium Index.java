// Example 1
// Input

// 4
// 2 3 1 1
// Output

// 1
// Explanation

// The value at index 1 is 3, we can see that sum of elements left of 3 is 2 and sum of elements right of 3 is 1+1=2 therefore 3 is the equilibrium index.
import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Solution.findEquilibriumIndex(a);
        System.out.println(ans);
    }
}

class Solution {
    static int findEquilibriumIndex(int[] a) {
		// tc O(N) sc O(1)
        int totalSum = 0;
		for(int i=0; i<a.length; i++){
			totalSum += a[i];
		}
		int lSum = 0;

		for(int i = 0; i < a.length; i++){
			lSum += a[i];
			int rSum = totalSum - lSum + a[i];
			if(lSum == rSum){
				return i;
			}
		}
		return -1;
    }
}
