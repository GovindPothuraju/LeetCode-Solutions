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
        if(head == null ) return null;
        if(head.next == null && n==1) return null;
        int count=0;
        ListNode temp=head;
        while(temp != null){
            count++;
            temp=temp.next;
        }
        if(count<n) return head;
        
        if(n==count){
            head=head.next;
            return head;
        }
        
        int i=1;
        int find=count-n;
        temp=head;
        while(i<find){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return head;
    }
}