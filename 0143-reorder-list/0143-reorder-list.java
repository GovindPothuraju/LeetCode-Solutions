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
    public void reorderList(ListNode head) {
        if(head==null || head.next ==null){
            return ;
        }
        // 1 find mid
        ListNode mid=getMid(head);
        ListNode left=head;
        ListNode right=mid.next;
        mid.next=null;

        //reverse after mid
        ListNode newRight=reverse(right);

        merge(left,newRight);
    }
    private ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    } 
    private ListNode reverse(ListNode right){
            ListNode curr=right;
            ListNode next=right;
            ListNode prev=null;
            while(curr !=null){
                next=next.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            right=prev;
            return  right;
    }
    private ListNode merge(ListNode head1,ListNode head2){
        ListNode lh=head1;
        ListNode rh=head2;
        ListNode nextlh=null;
        ListNode nextrh=null;
        while(lh!=null && rh!=null){
            nextlh=lh.next;
            lh.next=rh;
            nextrh=rh.next;
            rh.next=nextlh;

            lh=nextlh;
            rh=nextrh;
        }
        return head1;
    }
}