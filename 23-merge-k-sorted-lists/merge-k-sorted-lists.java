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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        //1st iteration:list[0] 2nd:list[1] 3rd:list[2]
        for(ListNode node:lists){
            if(node != null){ //condition for empty node cuz we're not adding null one to the pq
                pq.offer(node);
            }
        } //pq: 1 1 2
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while( !pq.isEmpty()){
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;
            if(smallest.next != null){
                pq.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}