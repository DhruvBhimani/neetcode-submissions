/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode left = dummy;
        ListNode right = dummy;

        // 2. Move 'right' forward 'n' times to create a gap of size n
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        // 3. Move both pointers together until 'right' hits the last node
        while (right.next != null) 
        {
            left = left.next;
            right = right.next;
        }

        // 4. 'left' is now standing right before the target node! Skip the target node.
        left.next = left.next.next;

        // 5. Return dummy.next because the original head might have been deleted
        return dummy.next;
    }
}
