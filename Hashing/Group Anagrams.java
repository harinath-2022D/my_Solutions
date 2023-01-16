// Example1
// Input

// 5
// cat dog tac god act
// Output

// cat tac act dog god
// Explanation

// cat, tac and act are anagrams of each other.

// dog and god are anagrams of each other.
// A Java program to print all anagrams together
import java.util.*;

public class Main {
   static String sortStr(String s) {
    // convert string to arr
    char[] arr = s.toCharArray();
    // sort the array
    Arrays.sort(arr);
    // convert arr to string
    return new String(arr);
}
 
static public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> hm = new TreeMap<>();
    int n = strs.length;
 
    for(int i = 0; i < n; i++) {
        String original = strs[i];
        String sorted = sortStr(original);
        if(hm.containsKey(sorted)) {
            List<String>oldlist = hm.get(sorted);
            oldlist.add(original);
            hm.put(sorted, oldlist);
        }
        else {
            List<String>newlist = new ArrayList<>();
            newlist.add(original);
            hm.put(sorted, newlist);
        }
    }
    List<List<String>> ans = new ArrayList<>();
    for(String key : hm.keySet()) {
        ans.add(hm.get(key));
    }
    return ans;
}

    

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
         List<List<String>> ans = groupAnagrams(wordArr);
		for(List<String> s : ans){
			for(String s1 : s)
			System.out.print(s1 + " ");
		}
    }
}
