import java.util.*;

class Solution {
	public boolean checkExcesswords(HashMap<String,Integer> ideal, HashMap<String,Integer> currhm){
		for(String str : currhm.keySet()){
			if(ideal.containsKey(str) == false ) return true;
			if(currhm.get(str) > ideal.get(str)) return true;
		}
		return false;
	}
    public List<Integer> findSubstring(String s, String[] words) {
        // write code here
		List<Integer> ans = new ArrayList<>();

		HashMap<String,Integer> ideal = new HashMap<>();
		for(int i=0; i<words.length; i++){
			ideal.put(words[i], ideal.getOrDefault(words[i], 0)+1);
		}

		int n = s.length();
		int totalWords = words.length;
		int wordlength = words[0].length();

		for( int i = 0; i < wordlength; i++){
			int sp = i;
		    int ep = i;

			HashMap<String, Integer> currhm = new HashMap<>();

		    while(ep+wordlength <= n){
				String currWord = s.substring(ep,ep+wordlength);
				currhm.put(currWord, currhm.getOrDefault(currWord,0)+1);
				ep+=wordlength;

				while(sp<ep && checkExcesswords(ideal,currhm)){
					String toBeDelete = s.substring(sp,sp+wordlength);
					currhm.put(toBeDelete, currhm.getOrDefault(toBeDelete, 0)-1);
					if(currhm.get(toBeDelete) == 0){
						currhm.remove(toBeDelete);
					}

					sp+=wordlength;
				}

				if(totalWords*wordlength == ep-sp){
					ans.add(sp);
				}
		    }
			
		}

		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}
