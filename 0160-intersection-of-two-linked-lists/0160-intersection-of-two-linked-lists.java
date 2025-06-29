/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*HashSet<ListNode> hs=new HashSet<>();
        ListNode temp=headA;
        while(temp!=null){
            hs.add(temp);
             temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(hs.contains(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return null;*/
        if(headA == null || headB ==null) return null;
        ListNode t1=headA;
        ListNode t2=headB;
        while(t1 != t2){
            t1=t1.next;
            t2=t2.next;
            if(t1 == t2) return t2;
            if(t1==null){
                t1=headB;
            }
            if(t2==null){  
                t2=headA;
            } 
        }
        return t1;
    }
}