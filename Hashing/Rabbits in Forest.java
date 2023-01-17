// Example 1
// Input

// 3
// 1 1 2
// Output

// 5
// Explanation
// The two rabbits that answered "1" could both be the same color, say red.
// The rabbit that answered "2" can't be red or the answers would be inconsistent.
// Say the rabbit that answered "2" was blue.
// Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
// The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
import java.util.*;

class Solution{
    public int numRabbits(int[] answers) {
        // write code here
		HashMap<Integer, Integer> freqmap = new HashMap<>();
		int ans = 0;
		for(int a : answers){
			freqmap.put(a, freqmap.getOrDefault(a,0)+1);
		}

		for(int key : freqmap.keySet()){
			int groupsize = key+1;
			int reporties = freqmap.get(key);

			int numOfGroups = reporties / groupsize;
			if(reporties % groupsize > 0){
				numOfGroups++;
			}
			ans+=numOfGroups * groupsize;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj =  new Solution();
        System.out.println(Obj.numRabbits(arr));
    }
}
