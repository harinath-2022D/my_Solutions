import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputLine[] = br.readLine().trim().split(" ");
        //size of array
        int n = Integer.parseInt(inputLine[0]);
        int start[] = new int[n];
        int end[] = new int[n];
        
        //adding elements to arrays start and end
        inputLine = br.readLine().trim().split(" ");
        for(int i = 0; i < n; i++)
            start[i] = Integer.parseInt(inputLine[i]);
        
        inputLine = br.readLine().trim().split(" ");
        for(int i= 0; i < n; i++)
            end[i] = Integer.parseInt(inputLine[i]);
        
        System.out.println(new Solution().solve(start, end, n));
    
    }
}

class Solution
{
    static class Pair{
		int s ;
		int e ;
		Pair(int e,int s){
			this.e = e;
			this.s = s;
		}
	}
    public static int solve(int start[], int end[], int n)
    {
        // add your code here
		Pair[] arr = new Pair[n];
		for(int i=0; i<n; i++){
			arr[i]=new Pair(end[i],start[i]);
		}
		Arrays.sort(arr,(a,b)->{
			return a.e-b.e;
		});

		int maxActivity = 0;
		int currTime = arr[0].e;
		int i = 1;
		while(i < n){
			int st = arr[i].s;
			if(st >= currTime){
				maxActivity++;
				currTime = st;
			}
			i++;
		}

		return 1;

    }
}
