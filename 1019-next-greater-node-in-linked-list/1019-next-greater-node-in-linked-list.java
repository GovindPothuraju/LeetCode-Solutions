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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        // convert to array
        int[] arr=new int[count];
        temp=head;
        int i=0;
        while(temp!=null){
            arr[i++]=temp.val;
            temp=temp.next;
        }
        // fing next greater for array
        Stack<Integer> st=new Stack<>();
        int res[]=new int[count];
        for(i=count-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i] ){
                st.pop();
            }
            res[i]=st.isEmpty()?0:arr[st.peek()];
            st.push(i);
        }

        return res;
    }
}