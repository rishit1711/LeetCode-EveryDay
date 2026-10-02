class Solution {
    public ListNode removeNodes(ListNode head) {

        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        Stack<Integer> st2 = new Stack<>();

        while (!st.isEmpty()) {

            int current = st.pop();

            if (st2.isEmpty() || current >= st2.peek()) {
                st2.push(current);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        Stack<Integer> st3=new Stack<>();
        while(!st2.isEmpty()){
            st3.push(st2.pop());
        }

        for (int i = 0; i < st3.size(); i++) {
            curr.next = new ListNode(st3.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }
}