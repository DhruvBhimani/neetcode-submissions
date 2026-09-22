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
        if(head  == null)
        {
            return null;
        }
        int size = 1;
       
        ListNode tmp = head;
        while(tmp.next != null)
        {
            size++;
            tmp = tmp.next;
        }
        ListNode tmp2 = head;

         if(size-n == 0)
        {
            head = head.next;
            return head;
        }
        
        for(int i = 0 ; i< size-n-1 ; i++)
        {
            tmp2 = tmp2.next;
        }
        
        tmp2.next = tmp2.next.next;
        return head;
    }
}
