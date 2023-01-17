// Example 1
// Input

// 7
// 0 1 0 2 0 1 0
// Output

// 3
// Explanation The subarray from index '1' to '3' is the longest subarray having equal number of 0's, 1's and 2's.
import java.util.*;

class Solution {
    public static int longestSubarray(int[] arr) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else if (num == 2) {
                count2++;
            }

            int d10 = count1 - count0;
            int d21 = count2 - count1;

            String code = d10 + "#" + d21;
            if (map.containsKey(code)) {
                int len = i - map.get(code);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(code, i);
            }
        }

        return maxLen;
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
        Solution Obj = new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
