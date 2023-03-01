import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int U=sc.nextInt();
        int V=sc.nextInt();
        Solution ob = new Solution();
        if (ob.check(N, M, Edges,U,V)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {
	boolean dfs(int src, int dest, ArrayList<ArrayList<Integer>> graph, boolean[] vis){
		if(src==dest) return true;

		vis[src] = true;
		for(int nbr : graph.get(src)){
			if(vis[nbr] == false){
				boolean check = dfs(nbr,dest,graph,vis);
				if(check) return true;
			}
		}
		return false;
	}
    
    boolean check(int Nodes, int edges, ArrayList<ArrayList<Integer>> Edges,int src,int dest) {
        // your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<=Nodes; i++){
			graph.add(new ArrayList<>());
		}

		for(ArrayList<Integer> e : Edges){
			int u = e.get(0);
			int v = e.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		boolean[] vis = new boolean[Nodes+1];
		return dfs(src,dest,graph,vis);
       
    }
}
