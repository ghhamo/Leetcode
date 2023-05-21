class Solution {
    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode res = head;
        head = reverseListByRecursion(head.next);
        temp.next = res;
        res.next = null;
        return head;
    }
    

    public ListNode reverseListByIterative(ListNode head) {
        if (head == null) return null;
        ListNode root = null;
        while (head != null) {
         ListNode cur = root;
         root = new ListNode(head.val);
         root.next = cur;
         head = head.next;
     }
        return root;
    }
}