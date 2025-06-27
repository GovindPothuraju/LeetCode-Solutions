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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        ListNode temp=head;
        while(temp!= null){
            int key=temp.val;
            hm.put(key,hm.getOrDefault(key,0)+1);
            temp=temp.next;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        temp=head;
        while(temp != null){
            if(hm.get(temp.val)>1){
                prev.next=temp.next;
            }else{
                prev=temp;
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}