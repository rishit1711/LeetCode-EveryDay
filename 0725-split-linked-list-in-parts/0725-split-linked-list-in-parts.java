class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head; 
        // len nikalo
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int split = len / k;
        int extra = len % k;
        ListNode[] arr = new ListNode[k];
        temp = head;
        // k heads honge
        for (int idx = 0; idx < k; idx++) {
            arr[idx] = temp;  // current part ka head
            int size = split;
            if (extra > 0) {
                size++;
                extra--;
            }
            for (int i = 1; i < size; i++) {
                if (temp != null) {
                    temp = temp.next;
                }
            }
            if (temp != null) {
                ListNode nayaPart = temp.next;
                temp.next = null;
                temp = nayaPart;
            }
        }

        return arr;
    }
}