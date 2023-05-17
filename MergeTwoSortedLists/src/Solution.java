class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode listNode = new ListNode();
        rec(list1, list2, listNode);
        return listNode;
    }

    public ListNode rec(ListNode l1, ListNode l2, ListNode current) {
        if (l1 == null && l2 == null) {
            return current;
        } else if (l1 == null) {
            current.val = l2.val;
            current.next = l2.next;
            return current;
        } else if (l2 == null) {
            current.val = l1.val;
            current.next = l1.next;
            return current;
        }
        if (l1.val < l2.val) {
            current.val = l1.val;
            current.next = new ListNode();
            rec(l1.next, l2, current.next);
        } else if (l1.val > l2.val) {
            current.val = l2.val;
            current.next = new ListNode();
            rec(l1, l2.next, current.next);
        } else {
            current.val = l1.val;
            current.next = new ListNode(l2.val);
            if (l1.next != null || l2.next != null) {
                current.next.next = new ListNode();
            }
            rec(l1.next, l2.next, current.next.next);
        }
        return current;
    }
}