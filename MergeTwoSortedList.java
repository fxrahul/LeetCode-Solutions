// https://leetcode.com/problems/merge-two-sorted-lists/

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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        /* O(n^2) Complexity // brute force approach
        if(head1 == null && head2 == null){
            return null;
        }if(head1 == null && head2 != null){
            return head2;
        }if(head1 != null && head2 == null){
            return head1;
        }
        ListNode copyh1 = head1;

        // Joining two linkedList
        while(head1.next != null){
            head1 = head1.next;
        }
        head1.next = head2;

        head1 = copyh1;



        int countForLL1 = 0;
        ListNode copyhead1= head1;        
        while(copyhead1!=null){
            copyhead1 = copyhead1.next;
            countForLL1 += 1;
        }



        for(int i=0;i<countForLL1;i++){
            copyhead1 = head1;
            while(copyhead1.next != null){
                if(copyhead1.val > copyhead1.next.val){
                    int temp = copyhead1.val;
                    copyhead1.val = copyhead1.next.val;
                    copyhead1.next.val = temp;
                }
                copyhead1 = copyhead1.next;
            }
          
        }

        return head1;
        */
        ListNode tempCopy = new ListNode(Integer.MIN_VALUE);
        ListNode temp = tempCopy;

        while(head1!=null && head2!=null){
            if(head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1!=null){ // remaining first list
            temp.next = head1;
            head1 = head1.next;
        }
        if(head2!=null){ // remaining second list
            temp.next = head2;
            head2 = head2.next;
        }
        return tempCopy.next; // as we started from dummy node;

    }
}