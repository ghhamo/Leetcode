class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head != null) {
            if (head.next == null && head.val != val) {
                return head;
            } else if (head.next == null) {
                return null;
            }
            if (head.val == val) {
                head = removeElements(head.next, val);
                return head;
            } else if (head.next.val == val) {
                head.next = removeElements(head.next.next, val);
                return head;
            } else {
                head.next = removeElements(head.next, val);
                return head;
            }
        }
        return null;
    }
}