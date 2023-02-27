import java.util.*;
 
class Main {
    public static void main(String[] args)
    {
        int[] arr = { 4, -4, 6, -6, 10, -11, 12 };
        int n = arr.length;
        int wrapSum = 0;
        int nonwrapSum = 0;
        int totalSum = 0;
 
        // Case1: get maximum circular array without
        // wrapping the array
        nonwrapSum = kadaneAlgo(arr, n);
 
        for (int i = 0; i < n; i++) {
            // finding the total sum
            totalSum += arr[i];
            // reverse the sign of elements
            arr[i] = -arr[i];
        }
 
        // Case2: after wrapping the elements, we get the
        // maximum sum
        wrapSum = totalSum - (-kadaneAlgo(arr, n));
 
        System.out.println(
            "Maximum circular subarray sum is "
            + Math.max(wrapSum, nonwrapSum));
    }
 
    /* function for kadane's algorithm i.e for finding the
     * maximum subarray sum */
    public static int kadaneAlgo(int[] arr, int n)
    {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
 
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
 
            if (currSum < 0) {
                currSum = 0;
            }
 
            maxSum = Math.max(maxSum, currSum);
        }
 
        return maxSum;
    }
}
