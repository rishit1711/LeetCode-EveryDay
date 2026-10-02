import java.math.BigInteger;

class Solution {
    public ListNode doubleIt(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode temp = head;
        while(temp != null){
            sb.append(temp.val);
            temp = temp.next;
        }
        BigInteger num = new BigInteger(sb.toString());
        BigInteger target = num.multiply(BigInteger.valueOf(2));
        String s = String.valueOf(target);
        ListNode dummy = new ListNode(0);
        temp = dummy;

        for(int i = 0; i < s.length(); i++){
            ListNode curr = new ListNode(s.charAt(i) - '0');

            temp.next = curr;
            temp = temp.next;
        }

        return dummy.next;
    }
}