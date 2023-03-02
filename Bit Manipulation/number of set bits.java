import java.util.*;

class Solution {
    public int setBits(int n) {
        
		int cnt = 0;
		int mask = 1;
		for(int i=0; i<32; i++){
			if((n & mask) != 0) cnt++;
			mask= mask<<1;
		}
		return cnt;

		// int cnt = 0;
		// while(n != 0){
		// 	n = n & (n-1);
		// 	cnt++;
		// }
		// return cnt;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setBits(n));
    }
}
