// Example 1
// Input

// gffg
// Output

// 6
// Explanation

// All possible substrings from the given string are, 
// ( “g“, “gf“, “gff”, “gffg”, “f“, “ff”, “ffg”, “f“, “fg“, “g” ) 
// Among them, the highlighted ones consists of distinct characters only.
// Java program to implement
// the above approach
import java.util.*;

public class Main {

    public static int DistinctCharacterSubstring(String s){
       int ans = 0;
 
    // Stores the frequency
    // of characters
    int []cnt = new int[26];
 
    // Initialised both pointers
    // to beginning of the String
    int i = 0, j = 0;
 
    while (i < n)
    {
 
        // If all characters in
        // subString from index i
        // to j are distinct
        if (j < n &&
           (cnt[str.charAt(j) - 'a'] == 0))
        {
 
            // Increment count of j-th
            // character
            cnt[str.charAt(j) - 'a']++;
 
            // Add all subString ending
            // at j and starting at any
            // index between i and j
            // to the answer
            ans += (j - i + 1);
 
            // Increment 2nd pointer
            j++;
        }
 
        // If some characters are repeated
        // or j pointer has reached to end
        else
        {
 
            // Decrement count of j-th
            // character
            cnt[str.charAt(i) - 'a']--;
 
            // Increment first pointer
            i++;
        }
    }
 
    // Return the final
    // count of subStrings
    return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ans = DistinctCharacterSubstring(s);
        System.out.println(ans);
    }
}
