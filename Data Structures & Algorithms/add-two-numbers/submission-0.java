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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int val1 =0;
        while(l1 != null)
        {
            val1 = (val1*10) + l1.val;
            l1 = l1.next;
        }
        String reversedText = new StringBuilder(String.valueOf(val1)).reverse().toString();
        val1 = Integer.parseInt(reversedText);

        int val2 =0;
        while(l2 != null)
        {
            val2 = (val2*10) + l2.val;
            l2 = l2.next;
        }
        String reversedText2 = new StringBuilder(String.valueOf(val2)).reverse().toString();
        val2 = Integer.parseInt(reversedText2);

        //System.out.println(val1);
        val1 = val1+val2;

        if (val1 == 0) 
        {
            return new ListNode(0);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy; 

        while (val1 > 0) 
        {
            int digit = val1 % 10;          // Grab the last digit (e.g., 5)
            curr.next = new ListNode(digit); // Stitch a new node into the list
            curr = curr.next;                // Move the builder pointer forward
            val1 = val1 / 10;                // Chop the digit off the sum
        }

        return dummy.next;
    }
    
}
