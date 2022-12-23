// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode temp1 = headA;
         ListNode temp2 = headB;
         if(headA==null || headB==null) return null;
         while(temp1!=temp2){ // if address of nodes equls then intersecting is true
             if(temp1==null)
             temp1=headB; // if temp1 reaches to end reassign it to satrt of headB
             else
             temp1=temp1.next;
             if(temp2==null)
             temp2=headA;
             else
             temp2=temp2.next;

         }
         return temp1;
    }
}
