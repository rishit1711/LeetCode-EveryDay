class Solution {
    public int[] nextLargerNodes(ListNode head) {

        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int[] ans = new int[len];
        int idx = 0;
        temp = head;
        while (temp != null) {
            ans[idx] = temp.val;
            idx++;
            temp = temp.next;
        }

        int n = ans.length;

        int[] nge = new int[n];

        nge[n - 1] = 0;

        st.push(ans[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= ans[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = 0;
            }
            else {
                nge[i] = st.peek();
            }

            st.push(ans[i]);
        }
        return nge;
    }
}