class Solution {
    public int evalRPN(String[] tokens) 
    {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i< tokens.length ; i++)
        {
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else
            {
                int temp1 = stack.peek();
                stack.pop();
                int temp2 = stack.peek();
                stack.pop();

                int result=0;

                if (tokens[i].equals("+")) 
                {
                    result = temp2 + temp1;
                }
                else if (tokens[i].equals("-")) 
                {
                    result = temp2 - temp1;
                }
                else if (tokens[i].equals("*")) 
                {
                    result = temp2 * temp1;
                }
                else if (tokens[i].equals("/")) 
                {
                    result = temp2 / temp1;
                }

                stack.push(result);

            }
        }

        return stack.peek();
    }
}
