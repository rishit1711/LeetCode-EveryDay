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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev=null;
        ListNode next=null;
        ListNode curr=head;
        int count=0;   // bhai k nodes hai bhi
        ListNode temp=head;
        for(int i=0;i<k;i++){
            if(temp==null){
                return head;
            }
            temp=temp.next;
        }

        // reverse code
        for(int i=0;i<k;i++){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // reverse hone ke bad head ekdum piche chala gya
        head.next=reverseKGroup(curr,k);
        return prev;
    }
}