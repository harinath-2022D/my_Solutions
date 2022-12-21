
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Linked_list obj = new Linked_list();
// 		Scanner sc = new Scanner(System.in);
// 		int n - sc.nextInt();
// 		for(int i = 0; i < n; i++){
// 		    int x = sc.nextInt();
// 		    obj.addNode(x);
// 		}
		obj.addNode(5);
		obj.addNode(10);
		obj.addNode(15);
// 		obj.deleteNth_Node(1);
// 		obj.deleteFirstNode();
// 	    obj.deleteLastNode();
// 		obj.insertAtBegin(0);
		obj.printList();
// 		obj.insertAt_K_Position(11,7);
// 		obj.printList();
	}
}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
class Linked_list{
    Node head;
    void addNode(int data){ // adding elements into linked list
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    
    void printList(){ // for printing linkedlist
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    
    
    void insertAtBegin(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        else{
          Node temp = head;
          newNode.next = temp;
          head = newNode;
        }
    }
    
    
    void insertAt_K_Position(int data,int k){
        
        if(k == 0){
            insertAtBegin(data);
        }
        else{
            Node temp = head;
            while(k>1 && temp != null){
                temp = temp.next;
                k-=1;
            }
            if(temp == null){
                System.out.print("can not insert at this position");
                return;
            }
            Node newNode = new Node(data);
            Node nxt = temp.next; // if nxt = null means last index
            temp.next = newNode;
            newNode.next = nxt;
            
        }
    }
    
    
    void deleteFirstNode(){
        if(head!=null){
            head=head.next;
        }
    }
    
    
    void deleteNth_Node(int position){
        if(head == null) return;
        if(position == 0){
            head = head.next;
        }
        int index = 0;
        Node temp = head;
        while(index+1 != position){
            temp = temp.next;
            index++;
        }
        temp.next = temp.next.next;
    }
    
    
    void deleteLastNode(){
        if(head == null){
            System.out.print("empty list");
        }
        else if(head != null && head.next == null){
            head = null; // if only one node in list
        }
        else{
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
    }
}

