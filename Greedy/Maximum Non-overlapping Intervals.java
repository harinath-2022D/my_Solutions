import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		Collections.sort(A,(a,b)-> {return a.get(1)-b.get(1);});

		int sp = A.get(0).get(0);
		int ep = A.get(0).get(1);

		int cnt = 0;
		
		for(int i=1; i<A.size(); i++){
			if(A.get(i).get(0)<=ep) cnt++;
			else{
				sp = A.get(i).get(0);
				ep = A.get(i).get(1);
			}
		}

		return A.size()-cnt;
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
