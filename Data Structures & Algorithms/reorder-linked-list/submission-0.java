class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // STEP 1: Find the middle of the list using Slow & Fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: Reverse the second half of the list (starting from slow.next)
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Cut the list in half to prevent cycles!

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // STEP 3: Weave the two halves together (head is first half, prev is second half)
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            // Save the next elements of both timelines
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Stitch the second half node right after the first half node
            first.next = second;
            second.next = temp1;

            // Advance both pointers forward to their saved steps
            first = temp1;
            second = temp2;
        }
    }
}
