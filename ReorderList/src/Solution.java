class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(node);
    }

    public static void reorderList(ListNode head) {
        ListNode current = head;
        while (true) {
            if (head.next == null || head.next.next == null) {
                return;
            }
            if (current.next.next == null) {
                ListNode cur = new ListNode(current.next.val);
                current.next = null;
                cur.next = head.next;
                head.next = cur;
                reorderList(head.next.next);
                return;
            }
            current = current.next;
        }
    }
}