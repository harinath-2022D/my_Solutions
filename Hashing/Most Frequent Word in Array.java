// Example 2
// Input

// 2
// hello world
// Output

// world


// Example 1
// Input

// 3
// geeks for geeks
// Output

// geeks

import java.io.*;
import java.util.*;

class Solution {
    public void mostFrequent(String []arr, int n) {
        HashMap<String, Integer> hm = new HashMap<>();

		String ans = "";
		int max = 0;

		for( int i=0; i<arr.length; i++){
			int cnt = hm.getOrDefault(arr[i], 0)+1;
			if(cnt >= max){
				max = cnt;
				ans = arr[i];
			}
			hm.put(arr[i],cnt);
		}
		
		System.out.print(ans);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String []arr = new String[n];
        for(int i=0;i<n;++i){
                arr[i] = sc.next();
        }
        Solution Obj = new Solution();
        Obj.mostFrequent(arr,n);  
        System.out.println('\n');
    }
}
