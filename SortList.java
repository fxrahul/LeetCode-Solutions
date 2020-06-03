// https://leetcode.com/problems/sort-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode left_ll = sortList(head);
        ListNode right_ll = sortList(slow);

        return sortMerge(left_ll,right_ll);
    }

    public ListNode sortMerge(ListNode a,ListNode b){
        ListNode temp = new ListNode(0);
        ListNode currentNode = temp;

        while(a!=null && b!=null){
            if(a.val<b.val){
                currentNode.next = a;
                a = a.next;
            }else{
                currentNode.next = b;
                b = b.next;
            }
            currentNode = currentNode.next;

        }

        if(a!=null){
            currentNode.next = a;
            a = a.next;
        }
        if(b!=null){
            currentNode.next = b;
            b = b.next;
        }
        return temp.next;
    }

}