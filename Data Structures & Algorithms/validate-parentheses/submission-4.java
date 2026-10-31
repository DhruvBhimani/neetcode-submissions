class Solution 
{
    public boolean isValid(String s) 
    {
        if(s.length()%2 != 0)
        {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i< s.length() ; i++)
        {
            if(stack.peek() == null )
            {
                stack.push(s.charAt(i));
            }
            else if((stack.peek() == '(' && s.charAt(i) == ')') ||
                    (stack.peek() == '{' && s.charAt(i) == '}') ||
                    (stack.peek() == '[' && s.charAt(i) == ']'))
            {
                stack.pop();
            }
            else
            {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
