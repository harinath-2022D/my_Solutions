import java.util.*;

class Solution {
	public boolean dfs(int cNode, int color, ArrayList<ArrayList<Integer>> graph, int[] vis){
		vis[cNode] = color;
		int nbrcolor = color == 1?2:1;

		for(int nbr : graph.get(cNode)){
			if(vis[nbr] == color) return false;
			else if(vis[nbr] == 0){
				boolean check = dfs(nbr,nbrcolor,graph,vis);
				if(!check) return false;
			}
		}
		return true;
	}
   
    public int possibleBipartition(int n, int[][] dislikes) {
        // Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=n; i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int arr[] : dislikes){
			graph.get(arr[0]).add(arr[1]);
			graph.get(arr[1]).add(arr[0]);
		}

		int[] vis = new int[n+1];
		for(int i=1; i<=n; i++){
			if(vis[i] != 0) continue;
			boolean check = dfs(i,1,graph,vis);
			if(!check) return 0;
		}
		return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}
