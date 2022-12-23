// Example 1
// Input

// 4
// 5 4 3 2
// Output:

// 3 

// Example 2
// Input

// 3
// 5 7 1
// Output:

// 7 

class Solution
{
    static Node midpointOfLinkedList(Node head)
    {
        if(head == null) return null;
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast= fast.next.next;
		}
		return slow;
    }
    
}
