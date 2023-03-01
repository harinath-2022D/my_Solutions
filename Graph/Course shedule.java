import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int canFinish(int n, int[][] prerequisites) {
        //write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++){
			graph.add(new ArrayList<>());
		}

		int[] vis = new int[n];

		for(int[] p : prerequisites){
			vis[p[1]]++;
			graph.get(p[0]).add(p[1]);
		}

		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		for(int i=0; i<n; i++){
			if(vis[i] == 0){
				q.add(i);
				count++;
			}
		}

		while(q.size() > 0){
			int currCourse = q.remove();
			for(int nc : graph.get(currCourse)){
				vis[nc]--;
				if(vis[nc] == 0){
					q.add(nc);
					count++;
				}
			}
		}

		if(count == n) return 1;
		return 0;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}
