import java.util.*;

class Solution {

public static void dfs(int i,int j,int[][] grid,List<Integer> li,int row,int col){
	if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
		return;
	}

	grid[i][j] = 0;
	li.add(i-row);
	li.add(j-col);

	dfs(i,j+1,grid,li,row,col);// right
	dfs(i-1,j,grid,li,row,col);// up
	dfs(i,j-1,grid,li,row,col);//left
	dfs(i+1,j,grid,li,row,col);//down
}
  
  public static int countDistinctIslands(int[][] grid) {
    // write your code here
	  int n = grid.length;
	  int m = grid[0].length;

	  Set<List<Integer>> set = new HashSet<>();

	  for(int i=0; i<n; i++){
		  for(int j=0; j<m; j++){
			  if(grid[i][j] == 1){
				  List<Integer> li = new ArrayList<>();
				  dfs(i,j,grid,li,i,j);
				  set.add(li);
			  }
		  }
	  }

	  return set.size();
  }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}
