public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
       // solution.removeElements(new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(10,new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,new ListNode(8,new ListNode(10,new ListNode(9))))))))))), 10);
        solution.removeElements(new ListNode(1, new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(1))))))))))), 1);
       // solution.removeElements(new ListNode(1), 2);
    }
}