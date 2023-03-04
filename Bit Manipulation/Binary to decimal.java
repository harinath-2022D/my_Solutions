import java.util.*;

class Accio{
    static int ASLoops6(String s){
        // write code here
		int res = 0;
		int pow = 1;
		for(int i=s.length()-1; i>=0; i--){
			int bit = (int)(s.charAt(i)-'0');
			res=res+pow*bit;
			pow = pow*2;
		}
		return res;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Accio obj = new Accio();
        int ans=obj.ASLoops6(s);
        System.out.println(ans);
    }
}
