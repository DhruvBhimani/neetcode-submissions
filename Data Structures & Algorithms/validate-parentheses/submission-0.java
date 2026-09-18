class Solution 
{
    public boolean isValid(String s) 
    {
        if(s.length()%2 != 0)
        {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = s.length() -1 ; i>=0 ; i--)
        {
            stack.push(s.charAt(i));
        }
        for(int i = 0 ; i< s.length()/2 ; i++)
        {
            if(stack.peekFirst()==s.charAt(i))
            {
                stack.pop();
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
