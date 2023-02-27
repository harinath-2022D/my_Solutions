import java.util.*;

class Solution {
    public ArrayList<Integer> FindIndices(String a, String b) {
        //Write your code here
		ArrayList<Integer> ans = new ArrayList<>();
		int p = a.length();
		int t = b.length();

		int i=0,j=t-1;

		while(j<p){
			if(b.equals(a.substring(i,j+1))){
				ans.add(i+1);
			}
			i++;
			j++;
		}

		if(ans.size() == 0){
			ans.add(-1);
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
	    Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.FindIndices(a, b);
        for(int x : ans)
            System.out.print(x + " ");
    }
}
