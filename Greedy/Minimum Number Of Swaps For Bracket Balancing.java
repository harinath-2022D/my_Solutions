import java.util.*;

class Solution {
    static int miniNumSwaps(String brackets, int n) {
        // write code here
		char[] ch = brackets.toCharArray();
		int countLeft = 0;
		int countRight = 0;
		int swaps = 0;
		int imbal = 0;
		
		for(int i=0; i<2*n; i++){
			if(ch[i]=='('){
				countLeft++;
				if(imbal > 0){
					swaps+=imbal;
					imbal--;
				}
				
			}else if(ch[i]==')'){
				countRight++;

				imbal = countRight-countLeft;
			}
		}

		return swaps;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String brackets = sc.next();
        int ans = Solution.miniNumSwaps(brackets, n);
        System.out.println(ans);
    }
}
