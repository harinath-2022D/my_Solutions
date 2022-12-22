//https://leetcode.com/problems/reverse-linked-list/
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = prev; // chain breaking
            prev = head; // direction changed
            head = nextNode;
        }
        return prev;
    }
}
