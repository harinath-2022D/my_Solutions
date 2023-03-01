import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	static class Pair{
		int first;
		int second;
		int steps;
		Pair(int first,int second,int steps){
			this.first = first;
			this.second = second;
			this.steps = steps;
		}
	}
    public static int[][] nearest(int[][] grid)
    {
        // your code here
		int n = grid.length;
		int m = grid[0].length;

		int[][] vis = new int[n][m];
		int[][] dis = new int[n][m];

		Queue<Pair> qu = new LinkedList<>();

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(grid[i][j] == 1){
					qu.add(new Pair(i,j,0));
					vis[i][j] = 1;
				}
			}
		}

		int[] delrow = {-1,0,+1,0};
		int[] delcol = {0,+1,0,-1};

		while(qu.size() > 0){
			Pair cp = qu.remove();
			int row = cp.first;
			int col = cp.second;
			int steps = cp.steps;

			dis[row][col] = steps;

			for(int i=0; i<4; i++){
				int drow = row+delrow[i];
				int dcol = col+delcol[i];

				if(drow>=0 && drow<n && dcol>=0 && dcol<m && vis[drow][dcol]==0){
					qu.add(new Pair(drow,dcol,steps+1));
					vis[drow][dcol] = 1;
				}
			}
		}

		return dis;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            int[][] ans = nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}
