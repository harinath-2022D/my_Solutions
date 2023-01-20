import java.util.*;

class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int []A=new int[n];
				int m=sc.nextInt();
				int k=sc.nextInt();
				for(int i=0;i<n;i++){
					A[i]=sc.nextInt();
				}
				Solution ob =new Solution();
				int ans = ob.minDays(A,n,m,k);
				System.out.println(ans);
				t--;
			}
		}
	}

}
class Solution {
	static boolean isPossible(int[] bloomDay,int cakes,int flavor,int mid){
		int rcakes = 0;
		int rflavor = 0;
		for(int value :  bloomDay){
			if(value<=mid){
				rflavor++;
			}else{
			     rflavor = 0;	
			}
			if(rflavor == flavor){
				rcakes++;
				rflavor = 0;
			}
		}
		return rcakes>=cakes;
	}
    public int minDays(int[] bloomDay,int n, int m, int k) {
		//Write code here
		int lo =Integer.MAX_VALUE;
		int hi =Integer.MIN_VALUE;
		for(int value : bloomDay){
		    lo = Math.min(lo,value);
			hi = Math.max(hi,value);
		}
		int potentialAns = -1;
		while(lo<=hi){
			int mid = (lo+hi)/2;
			if(isPossible(bloomDay,m,k,mid)){
				potentialAns = mid;
				hi = mid-1;
			}else{
				lo = mid+1;
			}
		}
		return potentialAns;
	}
}
