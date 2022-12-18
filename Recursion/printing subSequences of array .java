
import java.util.*;
public class Main
{
    public static void print(int index, ArrayList<Integer> ans, int[] arr, int n){
        if(index==n){
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
            return;
        }
        
        // taking
        ans.add(arr[index]);
        print(index+1,ans,arr,n);
        ans.remove(ans.size()-1);
        // not taking
        print(index+1,ans,arr,n);
    }
    public static void printSubsequences(int n,int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        print(0,ans,arr,n);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}
		printSubsequences(n,arr);
	}
}
