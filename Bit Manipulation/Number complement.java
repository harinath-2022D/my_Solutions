import java.util.Scanner;

class Solution{
public static int findComplement(int num){
	//Write your code here
	// for(int i=1; i<=num; i=i*2){
	// 	num^=i;
	// }
	return (num^num);
    }
}
public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	System.out.println(Solution.findComplement(num));
	sc.close();
    }
}
