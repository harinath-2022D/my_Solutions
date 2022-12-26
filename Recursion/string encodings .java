// Input
// 123
// Output
// ab
// aw
// lc
// Explanation
// We have three encoding, abc => {1,2,3}, aw => {1, 23}, lc => {12, 3}

// Example 2
// Input
// 013
// Output
// Explanation
// String starts with 0, which makes it invalid.

// Example 3
// Input
// 303
// Output
// Explanation
// We have no encoding as we can split str as {3, 0, 3}, {30, 3}, or {3, 03}. In {3, 0, 3} we dont have a character for 0. In {30, 3} we dont have a character for 30. In {3, 03}, 03 is invalid.

import java.util.*;

public class Main {
    static String str_to_value = " abcdefghijklmnopqrstuvwxyz";
    public static void printEncodings(String str,int index,String ans) {
        // Write your code here
        if(index==str.length()){
            System.out.println(ans);
            return;
        }
        
        if(str.charAt(index)=='0') return;
        int i = str.charAt(index)-'0';
      //taking as single
        printEncodings(str,index+1,ans+str_to_value.charAt(i));
        // taking as combined
        if(index<str.length()-1 && (str.charAt(index)=='1' || (str.charAt(index)=='2' && str.charAt(index)<='6'))){
            i=(str.charAt(index)-'0')*10 + (str.charAt(index+1)-'0');
        printEncodings(str,index+2,ans+str_to_value.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str,0,"");
    }
}
