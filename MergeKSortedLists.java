// https://leetcode.com/problems/merge-k-sorted-lists/

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
//     public ListNode mergeTwoList(ListNode head1,ListNode head2){
//          ListNode tempCopy = new ListNode(Integer.MIN_VALUE);
//         ListNode temp = tempCopy;

//         while(head1!=null && head2!=null){
//             if(head1.val < head2.val){
//                 temp.next = head1;
//                 head1 = head1.next;
//             }else{
//                 temp.next = head2;
//                 head2 = head2.next;
//             }
//             temp = temp.next;
//         }
//         if(head1!=null){ // remaining first list
//             temp.next = head1;
//             head1 = head1.next;
//         }
//         if(head2!=null){ // remaining second list
//             temp.next = head2;
//             head2 = head2.next;
//         }
//         return tempCopy.next; // as we started from dummy node;
//     }

    public ListNode mergeKSortedLists(ListNode[] lists,int k){
        ListNode head = null;
        ListNode last = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode> (){
            public int compare(ListNode a,ListNode b){
                return a.val - b.val;
            }
        });
        for(int i = 0 ; i < k ; i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        while(pq.isEmpty()==false){
            ListNode top = pq.poll();
            if(top.next!=null){
                pq.add(top.next);
            }
            if(head==null){
                head = top;
                last = top;
            }else{
                last.next = top;
                last = last.next;
            }
        }
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {

//         PriorityQueue<Integer> pQueue = new PriorityQueue<>(); 
//         for(ListNode l : lists){
//             while(l!=null){
//                 pQueue.add(l.val);
//                 l = l.next;
//             }
//         }
//         ListNode sorted = new ListNode(Integer.MIN_VALUE);
//         sorted.next = null;
//         ListNode sortedCopy = sorted;
//         ListNode temp = null;
//         // Iterator itr = pQueue.iterator(); 
//         while (pQueue.isEmpty()==false){
//             // System.out.print("working");
//             temp = new ListNode(pQueue.poll());
//             sorted.next = temp;
//             sorted = sorted.next;
//         }

//         return sortedCopy.next;

        // //using concept of merging two sorted list...
        // ListNode previousList = null;
        // int n = lists.length;
        // for(int i = 0; i < n; i++){
        //     ListNode list1 = previousList;
        //     ListNode list2 = lists[i];
        //     previousList = mergeTwoList(list1,list2);
        // }
        // return previousList;

        //using min heap.......

        int k = lists.length;
        return mergeKSortedLists(lists, k);

    }
}