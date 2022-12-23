// Remove Nth Node From End of List
// Input

// 6 2
// 1 2 3 4 5 6
// Output

// 1 2 3 4 6
// Explanation

// 2nd Node from the end is Node with value 5 

// We remove it and update the List  : 1-> 2-> 3-> 4-> 6

class Solution
{
    public static Node removeNthFromEnd(Node head, int n) {
    // finding length of linked lidt
		int size =0;
		Node temp1 = head;
		while(temp1!=null){
			size++;
			temp1=temp1.next;
		}
      // finding position of node from starting point
		int remove = size-n;
      //removing node
		if(remove==0){
			head=head.next;
			return head;
		}
		else{
		int index=0;
		Node temp = head;
		while(index+1!=remove){
			index++;
			temp=temp.next;
		}
		temp.next=temp.next.next;
		}
		return head;
}
}

