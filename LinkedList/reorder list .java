// https://leetcode.com/problems/reorder-list/description/
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]

class Solution {
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        // step 1 find mid element
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
       // step 2: reversing second half with staring mid element

        ListNode second = reverse(slow.next);
        slow.next=null;
        ListNode first = head;
        // merging first and second

        while(second!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        
    }
}
