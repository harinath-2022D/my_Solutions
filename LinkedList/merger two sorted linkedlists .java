// Input

// 3
// 1 2 4
// 3
// 1 3 4
// Output

// 1 1 2 3 4 4

class Solution {
static Node merge(Node head1, Node head2){
   
		 if(head1 == null) return head2;
		 if(head2 == null) return head1;

		 Node dummy = new Node(50);
		 Node head3 = dummy;

	     while(head1 != null && head2 != null){
			 if(head1.data < head2.data){
				 head3.next = head1;
				 head1 = head1.next;
			 }
			 else{
				 head3.next = head2;
				 head2 = head2.next;
			 }
			 head3 = head3.next;
		 }

		 if(head1 != null){
			 head3.next = head1;
		 }
		 else{
			 head3.next = head2;
		 }
		 return dummy.next;
	     
    }
}

