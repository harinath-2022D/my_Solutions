
import java.util.*;

class Solution {
	List<Integer>[] hashtable;// creating list of hashtable
	int size = 750000; // load factor 10^6 * 0.75
	Solution(){
		hashtable = new LinkedList[size];
	}
	public int hashFunction(int key){
		return key%size;
	}
    public void add(int key) {
        int index = hashFunction(key);

		if(hashtable[index] == null){
			hashtable[index] = new LinkedList<>(); // creating new linkedlist
		}

		if(hashtable[index].indexOf(key) == -1){
			hashtable[index].add(key); // after creating ll adding key
		}
    }

    public void remove(int key) {
        int index = hashFunction(key);

		if(hashtable[index] == null){
			return;
		}

		if(hashtable[index].indexOf(key) != -1){
			hashtable[index].remove(hashtable[index].indexOf(key));
		}
    }

    public boolean contains(int key) {
        int index = hashFunction(key);

		if(hashtable[index] == null || hashtable[index].indexOf(key) == -1){
			return false;
		}
		return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}
