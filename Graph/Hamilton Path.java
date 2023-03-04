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
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	boolean hamilton(int curr,boolean[] vis,ArrayList<ArrayList<Integer>> graph,ArrayList<Integer> psf,int os){
		int totalNodes = graph.size()-1;
		if(psf.size() == totalNodes - 1){
			return true;
		}

		vis[curr] = true;
		psf.add(curr);

		boolean myRes = false;
		for(int nbr : graph.get(curr)){
			if(!vis[nbr]){
				boolean findAPath = hamilton(nbr,vis,graph,psf,os);
				if(findAPath) myRes = true;
			}
		}

		vis[curr] = false;
		psf.remove(psf.size()-1);
		return myRes;
	}
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++){
			graph.add(new ArrayList<>());
		}

		for(ArrayList<Integer> e : Edges){
			int u = e.get(0);
			int v = e.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		boolean[] vis = new boolean[N+1];
		ArrayList<Integer> psf = new ArrayList<>();
		boolean ans = false;

		for(int i=1; i<=N; i++){
			boolean isHamilton = hamilton(i,vis,graph,psf,i);
			ans = ans || isHamilton;
		}

		return ans;
    
    }
}
