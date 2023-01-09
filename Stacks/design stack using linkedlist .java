
import java.util.*;

class Node {

    int data;
    Node link;
}

class Main {
	public static void main(String[] args)
	{
		StackUsingLinkedlist obj = new StackUsingLinkedlist();
		Scanner sc = new Scanner(System.in);
        int q;
        q = sc.nextInt();
        while(q-->0){
            int x;
            x = sc.nextInt();
            if(x==1){
                int y;
                y = sc.nextInt();
                obj.push(y);
            }
            if(x==2){
                System.out.println(obj.peek());
            }
            if(x==3){
                obj.pop();
            }
            if(x==4){
                Node temp = obj.display();
                while (temp != null) {

                    System.out.print(temp.data+" ");

                    temp = temp.link;
			    }
				System.out.println();
            }
        }
	}
}

class StackUsingLinkedlist {

	Node top;
	StackUsingLinkedlist() { this.top = null; }

	public void push(int x)
	{
		//Complete the function
		Node tmp = new Node();
		tmp.data = x;
		tmp.link = top;
		top = tmp;
	}

	public int peek()
	{
		//Complete the function
		if(top == null) return -1;
		else{
			return top.data;
		}
	}

	public void pop()
	{
		//Complete the function
		if( top == null) return;
		else{
			Node forw = new Node();
			forw = top.link;
			top.link = null;
		    top = forw;
		}
	}

	public Node display()
	{
		//Complete the function
		return top;
	}
}
