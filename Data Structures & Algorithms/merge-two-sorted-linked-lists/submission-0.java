class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        // 1. Create a dummy node to act as our stable anchor
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;   // This pointer moves forward to build the chain

        while (list1 != null && list2 != null) 
        {
            if (list1.val <= list2.val) 
            {
                curr.next = list1;   
                list1 = list1.next;  
            } 
            else 
            {
                curr.next = list2;   
                list2 = list2.next;  
            }
            curr = curr.next; 
        }


        if (list1 != null) 
        {
            curr.next = list1;
        } 
        else 
        {
            curr.next = list2;
        }

        // 4. Return dummy.next because dummy itself is just an empty placeholder
        return dummy.next;
    }
}
