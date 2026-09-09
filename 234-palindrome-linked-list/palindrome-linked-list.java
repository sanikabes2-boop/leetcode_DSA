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
    public boolean isPalindrome(ListNode head) {
        //phle reverse karde phir compare karna glt hoga kyuki aise og list ke links change ho jayenge == extra space lene ke chances honge
        // second half list ko reverse kar ke dekh sakte hai
        //Find middle → Reverse second half → Compare.
        if(head == null || head.next == null){
            return true;
        }
        
        //now find the middle here slow will be middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //abhi slow se reverse krdo rest of the list
        ListNode next=null;
        ListNode prev=null;

        while(slow!=null){
            next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }

        //abhi compare kro
        // prev -> last node abhi 
        ListNode first = head;
        ListNode second = prev;

        while(second != null){
            if(first.val != second.val)
                return false;
            first=first.next;
            second = second.next;
        }
        return true;
    }
}