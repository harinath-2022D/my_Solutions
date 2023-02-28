import java.util.Scanner;

class Solution{
    static int findLengthOfSmallestSubarray(int[] a, int K) {
        //Write your code here
		int n = a.length;
		int sp = 0;
		int ep = 0;
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		while(ep < n){
			sum+=a[ep];
			while(sum>=K){
				ans = Math.min(ans, ep-sp+1);
				sum-=a[sp];
				sp++;
		    }
			ep++;
		}

		return ans;
    }
}
public class Main{ 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
		int K = keyboard.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();
        System.out.println(Solution.findLengthOfSmallestSubarray(a, K));
    }
}
