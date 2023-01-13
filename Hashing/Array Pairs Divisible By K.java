// Example 1
// Input

// 10 5
// 1 2 3 4 5 10 6 7 8 9
// Output

// true
// Explanation

// Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10)
import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i< arr.length; i++){
			int rem = arr[i]%k;
			map.put(rem, map.getOrDefault(rem,0)+1);
		}

	    for(int rem : map.keySet()){
			if( rem == 0){
				continue;
			}
			int comRem = k-rem;
			if(map.containsKey(comRem) == false){
				return false;
			}
			else if(map.get(comRem) != map.get(rem)){
				return false;
			}
		}
		return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
		k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if(Obj.arrayPairs(arr,k)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
    }
}
