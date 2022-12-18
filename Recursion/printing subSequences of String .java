
import java.util.*;
import java.util.Scanner;

public class Main{
	static void print_subsequence(String  str,String ans,int index){
		if(index==str.length()){
			if(ans.length()>0)
			System.out.print(ans+" ");
			return;
		}
		print_subsequence(str,ans+str.charAt(index),index+1);
		print_subsequence(str,ans,index+1);
	}
    static void printSubsequence(String s) {
        //Write your code here
		print_subsequence(s,"",0);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printSubsequence(s);
    }
}
