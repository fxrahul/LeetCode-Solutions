// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempStart = new ListNode(Integer.MIN_VALUE);
        tempStart.next = head; //as if we want to remove first element then we need one element before first element
        ListNode forward = tempStart;
        ListNode backward = tempStart;
        for(int i = 1; i <= n + 1; i++){ //n+1 since we will use previous element to remove next element. if we go to element that we have to remove . we have no reference of previous element...
            forward = forward.next;
        }

        while(forward!=null){
            forward = forward.next;
            backward = backward.next;
        }
        backward.next = backward.next.next;

        return tempStart.next; // as head is stored in next of tempStart.......

    }
}