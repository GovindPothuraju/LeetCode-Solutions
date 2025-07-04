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
        ListNode temp=new ListNode(-1);
        ListNode t1=reverse(l1);
        ListNode t2=reverse(l2);
        ListNode t3=temp;
        int carry=0;
        while(t1 != null && t2!=null){
            int sum=t1.val+t2.val+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
                ListNode t4=new ListNode(sum);
                t3.next=t4;
                t3=t3.next;
            }else{
                carry=0;
                ListNode t4=new ListNode(sum);
                t3.next=t4;
                t3=t3.next;
            }
            t1=t1.next;
            t2=t2.next;
        }
        while(t1 != null){
            int sum=t1.val+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
                ListNode t4=new ListNode(sum);
                t3.next=t4;
                t3=t3.next;
            }else{
                carry=0;
                ListNode t4=new ListNode(sum);
                t3.next=t4;
                t3=t3.next;
            }
            t1=t1.next;
        }
        while(t2 != null){
            int sum=t2.val+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
                ListNode t4=new ListNode(sum);
                t3.next=t4;
                t3=t3.next;
            }else{
                carry=0;
                ListNode t4=new ListNode(sum);
                t3.next=t4;
                t3=t3.next;
            }
            t2=t2.next;
        }
        if(carry ==1){
            ListNode newnode=new ListNode(1);
            t3.next=newnode;
            newnode.next=null;
        }
        return reverse(temp.next);
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head;
        while(curr != null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }
}