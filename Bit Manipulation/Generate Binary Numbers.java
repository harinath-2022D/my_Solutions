import java.util.*;

class Solution {
    public void binaryRepresentation(int n) {
        //Write code here and print output
         
         Queue<String> q = new LinkedList<>();
		q.add("1");
		for(int i=1; i<=n; i++){
			String s1 = q.remove();
			System.out.print(s1+" ");
			q.add(s1+"0");
			q.add(s1+"1");
		}
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Solution Obj = new Solution();
        Obj.binaryRepresentation(n);
        sc.close();
    }
}


