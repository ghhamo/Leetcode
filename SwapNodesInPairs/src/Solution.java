class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int roadTraveled = 0;
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        ListNode current = head.next;
        if (current == null) {
            return newHead;
        }
        ListNode changeable = current.next;
        while (current.next != null) {
            if (roadTraveled % 2 == 0) {
                ListNode node = changeable.next;
                head.next = changeable;
                changeable.next = current;
                current.next = node;
                current = changeable;
            }
            head = head.next;
            current = current.next;
            changeable = current.next;
            ++roadTraveled;
        }
        return newHead;
    }
}