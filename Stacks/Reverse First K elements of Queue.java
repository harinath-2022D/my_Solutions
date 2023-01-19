// Example 1
// Input:

// 5 3
// 1 2 3 4 5
// Output:

// 3 2 1 4 5
// Explanation:

// 1 2 3 are first K elements. Thus after reversing them, the final list is 3 2 1 4 5.
import java.util.*;
import java.io.*;

public class Main {
	static void reverseQueueFirstKElements(int k,Queue<Integer> queue){
		if (queue.isEmpty() == true
      || k > queue.size())
      return;
    if (k <= 0)
      return;

    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < k; i++) {
      stack.push(queue.peek());
      queue.remove();
    }

    while (!stack.empty()) {
      queue.add(stack.peek());
      stack.pop();
    }

    for (int i = 0; i < queue.size() - k; i++) {
      queue.add(queue.peek());
      queue.remove();
    }
	}
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q.add(input.nextInt());
        }
        // write code here
		reverseQueueFirstKElements(k,q);
        while(q.size() > 0){
            System.out.print(q.poll() + " ");
        }
    }
}
