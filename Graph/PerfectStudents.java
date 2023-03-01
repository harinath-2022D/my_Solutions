import java.io.*;
import java.util.*;
  class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
class Solution{
	public static void creatComp(int cNode, ArrayList<Integer> comp,ArrayList<Edge>[] graph, boolean[] vis){
		vis[cNode]=true;
		comp.add(cNode);
		for(Edge e : graph[cNode]){
			if(vis[e.nbr] == false){
				creatComp(e.nbr,comp,graph,vis);
			}
		}
	}
    public static int perfectStudents(int v,  ArrayList<Edge>[] graph){
       // Your code here
		boolean[] vis = new boolean[v];
		ArrayList<ArrayList<Integer>> components = new ArrayList<>();

		for(int i = 0; i<v; i++){
			if(vis[i] == false){
				ArrayList<Integer> comp = new ArrayList<>();
				creatComp(i,comp,graph,vis);
				components.add(comp);
			}
		}

		int pairs = 0;
		for(int i=0; i<components.size(); i++){
			for(int j=i+1; j<components.size(); j++){
				int count = components.get(i).size()*components.get(j).size();
				pairs+=count;
			}
		}

		return pairs;
   }
}
public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = k;
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
      System.out.println(Solution.perfectStudents(n, graph));
   }

}
