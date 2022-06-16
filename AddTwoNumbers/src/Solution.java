class Solution {
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode root = new ListNode(1);
        ListNode prev = root;
        int carry = 0;
        int digit;
        while (node1 != null && node2 != null) {
            int node1Val = node1.val;
            int node2Val = node2.val;

            int sum = node1Val + node2Val + carry;
            if (sum >= 10) {
                digit = sum % 10;
                carry = 1;
            } else {
                digit = sum;
                carry = 0;
            }
            prev.next = new ListNode(digit);
            prev = prev.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode node = node1 != null ? node1 : node2;
        while (node != null && carry == 1) {
            int value = node.val;
            int sum = value + carry;
            if (sum >= 10) {
                digit = sum % 10;
            } else {
                digit = sum;
                carry = 0;
            }
            prev.next = new ListNode(digit);
            prev = prev.next;
            node = node.next;
        }
        while (node != null) {
            int value = node.val;
            prev.next = new ListNode(value);
            prev = prev.next;
            node = node.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        return root.next;
    }
}