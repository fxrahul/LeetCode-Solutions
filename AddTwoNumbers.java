
// https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(Integer.MAX_VALUE, null);
        ListNode l3Copy = l3;
        ListNode temp = new ListNode();
        int sum = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null && l2 == null){
                sum = l1.val;
                l1 = l1.next;
            }else{
                sum = l2.val;
                l2 = l2.next;
            }

            if(carry == 1){
                sum = sum + 1;
            }
            if(sum > 9){
                temp = new ListNode(sum-10,null);
                l3.next = temp;
                l3 = l3.next;
                carry = 1;

            }else{
                temp = new ListNode(sum, null);
                l3.next = temp;
                l3 = l3.next;
                carry = 0;
            }

        }

        if(carry == 1){

            temp = new ListNode(carry,null);
            l3.next = temp;
            l3 = l3.next;
        }


        l3 = l3Copy.next;
        return l3;

    }
}