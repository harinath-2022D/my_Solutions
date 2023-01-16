import java.io.*;
import java.util.*;
class Stack
{
	Queue<Integer> queue = new LinkedList<>();
    void push(int a)
    {
        // your code here
		queue.add(a);
    }
    
    int pop()
    {
        // your code here
		if(queue.size()==0) return -1;
		for(int i = 0; i < queue.size()-1; i++){
			queue.add(queue.remove());
		}
		return queue.remove();
    }	
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);    
        Stack g = new Stack();			
        int q = sc.nextInt();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1){
                int a = sc.nextInt();
                    // call push function here
				g.push(a);
            }
            else if(QueryType == 2){
                    // call pop function here
				System.out.print(g.pop()+" ");
            }
            q--;
        }	
    }
}

// implement stack using queue pop(1)
import java.io.*;
import java.util.*;
class Stack
{
	Queue<Integer> queue = new LinkedList<>();
    void push(int a)
    {
        // your code here
		queue.add(a);
		for(int i = 0; i < queue.size()-1; i++){
			queue.add(queue.remove());
		}
    }
    
    int pop()
    {
        // your code here
		if(queue.size() == 0) return -1;
		return queue.remove();
    }	
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);    
        Stack g = new Stack();			
        int q = sc.nextInt();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1){
                int a = sc.nextInt();
                    // call push function here
				g.push(a);
            }
            else if(QueryType == 2){
                    // call pop function here
				System.out.print(g.pop()+" ");
            }
            q--;
        }	
    }
}
