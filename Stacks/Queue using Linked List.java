import java.util.*;
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next =  null;
	}
}
class Queue {
    //Write your code here
	Node head;
	Node tail;
	int count = 0;
    public void push(int value) {
        //Write your code here
		Node tmp = new Node(value);
		if(head == null){
			head = tmp;
			tail = tmp;
		}
		else{
			tail.next = tmp;
			tail = tmp;
		}
		count++;
    }
    public int pop() {
        //Write your code here
		if(head == null){
			tail = null;
			return -1;
		}
		int ans = head.data;
		head = head.next;
		count--;
		return ans;
    }
    public int front() {
        //Write your code here
		if(head == null){
			return -1;
		}
		return head.data;
    }
    public int getSize() {
        //Write your code here
		return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                q.push(x);
            }
            else if(op == 2) {
                System.out.println(q.pop());
            }
            else if(op == 3)
                System.out.println(q.front());
            else if(op == 4)
                System.out.println(q.getSize());
        }
    }
}
