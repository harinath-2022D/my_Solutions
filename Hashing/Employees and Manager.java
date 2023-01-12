// Example
// Input

// 6
// A C
// B C
// C F
// D E
// E F
// F F
// Output

// A 0  
// B 0
// C 2
// D 0
// E 1
// F 5 
// Explanation

// Each denotes number of employees directly and indirectly under the manager. F is the CEO therefore all other employees are under him
import java.io.*;
import java.util.*;

class Solution {
	public int solve(String ceo, HashMap<String ,ArrayList<String>> mgnr,TreeMap<String, Integer> ans){
		// base case
		if(mgnr.containsKey(ceo) == false){
			ans.put(ceo,0);
			return 1;
		}
		// recursive case

		int cnt = 0;
		// count all employees under ceo
		for(String emp : mgnr.get(ceo)){
			cnt += solve(emp, mgnr, ans);
		}
		ans.put(ceo, cnt);
		return cnt+1;
	}

    public void EmpUnderManager(Map<String, String> emp)
	{
		HashMap<String ,ArrayList<String>> mgnr = new HashMap<>();
		String ceo ="";

		for(String employee : emp.keySet()){
			String myManager = emp.get(employee);

			if(myManager.equals(employee)){
				ceo = employee;
				continue;
			}
			
		if(mgnr.containsKey(myManager) ){
			ArrayList<String> tmp = mgnr.get(myManager);
			tmp.add(employee);
			mgnr.put(myManager, tmp);
		}
			else{
				ArrayList<String> newList = new ArrayList<>();
				newList.add(employee);
				mgnr.put(myManager, newList);
			}
		}
		// sorting keys

		TreeMap<String, Integer> ans = new TreeMap<>();
		solve(ceo, mgnr, ans);

		for(String key : ans.keySet()){
			System.out.println(key +" "+ans.get(key) );
		}

	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}
