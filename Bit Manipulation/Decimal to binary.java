import java.util.*;
import java.io.*;

class Main{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        Solution obj = new Solution();
        obj.toBinary(N);
        System.out.println();
    
	}
}

class Solution{
	void toBinary(int n) {
		//Write your code here
		int[] bits = new int[32];
		int i = 0;
		while( n > 0){
			bits[i] = n % 2;
			n = n / 2;
			i++;
		}

		for(int j=i-1;j>=0;j--){
			System.out.print(bits[j]);
		}
        
	}
}
