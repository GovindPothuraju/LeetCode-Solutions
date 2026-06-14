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
    public int pairSum(ListNode head) {
        if(head.next == null) return head.val;
        ListNode mid = getMid(head);

        ListNode right = reverse(mid);

        ListNode left = head;

        int ans = Integer.MIN_VALUE;
        while(left!=null &&  right!=null){
            int sum = left.val+right.val;
            ans = Math.max(ans,sum);

            left = left.next;
            right = right.next;
        }
        return ans;
    }
    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(curr != null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}