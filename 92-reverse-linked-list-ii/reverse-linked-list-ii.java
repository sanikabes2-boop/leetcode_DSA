/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //creating a dummy node that has value 0 and will point to head: 0>1>2>3>4>5>NULL
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //NOW prev = dummy
        ListNode prev = dummy;
        //move prev till left ke phle
        for(int i = 1; i<left; i++){
            prev = prev.next;
        }
        ListNode curr = prev.next;
        //now reverse the req part
        //agar node 2 to 4 reverse karna hai to 
        /*2,3,4 ko 4,3,2 banana hoga 
        3 ek kadam aage aayega to 3, 2, 4
        phir 4 bhi do kadam aage aayega 4, 3, 2
        2 iterations: right-left = 4-2 = 2
        */

        for(int i=0; i<right - left; i++){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next=next;
        }
        return dummy.next;
    }
}