// Example 1
// Input

// 6
// 5 10 3 2 50 80
// 78
// Output

// 1
import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int []A, int n, int B) {
        HashSet<Integer> set = new HashSet<>();
		// x-y =B
		for(int i=0; i<n; i++){
			// x= A[i] , y = A[i]-B
			// x= B+A[i] , y = A[i]
			if(set.contains(A[i]-B) || set.contains(B+A[i])){
				return 1;
			}
			set.add(A[i]);
		}
		return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,B;
        n = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.givenDifference(mat,n,B));
        System.out.println('\n');
    }
}
