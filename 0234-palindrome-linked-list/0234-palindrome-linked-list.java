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
        if(head== null || head.next==null) return true;
        // get mid
        ListNode mid=getmid(head);
        //reverse
        ListNode prev=null;
        ListNode curr=mid;
        ListNode next=mid;
        while(curr != null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode right=prev;
        ListNode left=head;
        //traverse from both ends
        while(right != null ){
            if(left.val != right.val){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    private ListNode getmid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}