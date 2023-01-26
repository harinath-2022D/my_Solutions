import java.io.*;
import java.util.*;

class Solution {
    public long pairDifference(int []A, int n, int k) {
       // write code here
		HashMap<Integer, Integer> map = new HashMap<>();
		long ans = 0;
		// creating freq map
		for(int val : A){
			map.put(val, map.getOrDefault(val,0)+1);
		}

		for(int key : map.keySet()){
			if(k == 0){
				if(map.get(key)>1) ans++;
			}else{
				if(map.containsKey(key+k) && map.get(key+k)>0) ans++;
				if(map.containsKey(key-k) && map.get(key-k)>0) ans++;
			}
			map.put(key, 0);
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.pairDifference(mat,n,k));
        System.out.println('\n');
    }
}
