import java.io.*;
import java.util.*;

class Solution{
	static char flip(char c)
    {
        return (c == '0') ? '1' : '0';
    }
    static String complement(String bin){
        //Write your code here
		 int n = bin.length();
  //       int i;
  
  //       String ones = "", twos = "";
  //       ones = twos = "";
  
  //       // for ones complement flip every bit
  //       for (i = 0; i < n; i++)
  //       {
  //           ones += flip(bin.charAt(i));
  //       }
  // System.out.println(ones);
  //       // for two's complement go from right to left in
  //       // ones complement and if we get 1 make, we make
  //       // them 0 and keep going left when we get first
  //       // 0, make that 1 and go out of loop
  //       twos = ones;
  //       for (i = n - 1; i >= 0; i--)
  //       {
  //           if (ones.charAt(i) == '1')
  //           {
  //               twos = twos.substring(0, i) + '0' + twos.substring(i + 1);
				
  //           } 
  //           else
  //           {
  //               twos = twos.substring(0, i) + '1' + twos.substring(i + 1);
  //               break;
  //           }
  //       }
  
  //       // If No break : all are 1 as in 111 or 11111;
  //       // in such case, add extra 1 at beginning
  //       if (i == -1)
  //       {
  //           twos = '1' + twos;
  //       }

		// return twos;
		String two = "";
		String first="";
		String second ="";
		String rev="";
		for(int i=n-1; i>=0; i--){
			if(bin.charAt(i)=='1'){
				 first = bin.substring(i);
				second = bin.substring(0,i);
				break;
			}
		}
		for(int i=0;i<second.length(); i++){
			if(second.charAt(i)=='1'){
				rev+='0';
			}else{
				rev+='1';
			}
		}

		two=rev+first;
		return two;
    }
}
public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String bi = in.readLine();
        Solution ob = new Solution();
        System.out.println(ob.complement(bi));
    }
}
