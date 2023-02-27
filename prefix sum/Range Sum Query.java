import java.util.*;

class Solution {
	public int rangeSum(int[] presum, int sp, int ep){
		if(sp==0) return presum[ep];
		return presum[ep]-presum[sp-1];
	}
        public int[] sumQuery(int[] arr, int[][] ranges) {
            // Your code here.
			int[] ans = new int[ranges.length];

			int[] presum = new int[arr.length];
			int sum = 0;

			for(int i=0; i<arr.length; i++){
				sum+=arr[i];
				presum[i]=sum;
			}

			for(int q = 0; q < ranges.length; q++){
				int sp =ranges[q][0];
				int ep = ranges[q][1];
				ans[q] = rangeSum(presum, sp, ep);
			}
			return ans;
        }
}

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}
