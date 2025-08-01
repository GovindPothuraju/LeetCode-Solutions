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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        //mid
        ListNode mid=getMid(head);
        //mergesort of left and right
        ListNode rightNode=mid.next;
        mid.next=null;
        ListNode newLeft=sortList(head);
        ListNode newRight=sortList(rightNode);
        //merge
        return merge(newLeft,newRight);
    }
    private ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode head1,ListNode head2){
        ListNode linkedll=new ListNode(-1);
        ListNode temp=linkedll;
        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
                head1=head1.next;
                temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
                head2=head2.next;
                temp=temp.next;
        }
        return linkedll.next;
    }
}