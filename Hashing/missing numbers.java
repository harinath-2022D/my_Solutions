// Example 1
// Input

// 10 
// 203 204 205 206 207 208 203 204 205 206 
// 13 
// 203 204 204 205 206 207 205 208 203 206 205 206 204
// Output

// 204 205 206
// Explanation

// 203 is in both arr and brr and its frequency is 2 in both arrays, hence it is not included in output

// 204 is included in both arrays but have different frequency hence, it is included in output

// Similarly other numbers are considered
import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();
		// counting fre of second array
		for(Integer i : brr){
			hm.put(i, hm.getOrDefault(i,0)+1);
		}
		// if first arry contains sama ele as second then decreasing fre
		for(Integer j : arr){
			if(hm.containsKey(j)){
				hm.put(j,hm.get(j)-1);
			}
		}
//adding remaining ele to the arraylist
		for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
			if(entry.getValue() != 0){
				ans.add(entry.getKey());
			}
		}
		
		if(ans.size()==0) System.out.print(-1);
		
		Collections.sort(ans);
		for(int i=0; i<ans.size(); i++){
			System.out.print(ans.get(i)+" ");
		}
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}
