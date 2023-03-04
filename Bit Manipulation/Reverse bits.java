import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static long reverse(long A) {
	    // Your code here
		long ans = 0;
		for(int i=0; i<32; i++){
			long lsb = A & 1;
			long tmp = lsb<<(31-i);
			ans = ans | tmp;
			A = A>>1;
		}
		return ans;
	}
}
public class Main {
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    	long n = sc.nextLong();
			System.out.println(Solution.reverse(n));
	}
}
