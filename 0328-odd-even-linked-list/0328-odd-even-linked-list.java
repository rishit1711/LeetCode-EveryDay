class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy1=new ListNode(0);
        ListNode dummy2=new ListNode(-1);
        ListNode t1=dummy1;
        ListNode t2=dummy2;
        int count=1;
        while(head!=null){
            if(count%2!=0){
                t1.next=head;
                t1=t1.next;
            }else{
                t2.next=head;
                t2=t2.next;
            }head=head.next;
            count++;
        }t2.next=null;
        t1.next=dummy2.next;
        return dummy1.next;
    }
}