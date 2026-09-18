
class Solution 
{
    public boolean isValid(String s) 
    {
        if(s.length() % 2 != 0)
        {
            return false;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        // Loop 1: Process every character
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(stack.peek() == null)
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
        
        // FIX: If the string was valid, every opener found its closer, 
        // leaving the stack completely empty!
        return stack.isEmpty();
    }
}
