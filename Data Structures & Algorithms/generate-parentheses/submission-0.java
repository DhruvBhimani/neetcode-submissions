class Solution {
    public List<String> generateParenthesis(int n) 
    {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        
        // Launch your backtracking helper starting with 0 open and 0 closed brackets
        backtrack(0, 0, n, stack, res);
        return res;
    }

    private void backtrack(int openN, int closedN, int n, StringBuilder stack, List<String> res) 
    {
        // Base Case: If both counters hit n, we successfully built a balanced sequence!
        if (openN == n && closedN == n) 
        {
            res.add(stack.toString());
            return;
        }

        // Choice 1: If we have open slots left, we can always append an open parenthesis
        if (openN < n) 
        {
            stack.append("(");              // Choose
            backtrack(openN + 1, closedN, n, stack, res); // Explore
            stack.deleteCharAt(stack.length() - 1);       // Unchoose (Pop)
        }

        // Choice 2: We can only add a closing parenthesis if there's an open one waiting for it
        if (closedN < openN) 
        {
            stack.append(")");              // Choose
            backtrack(openN, closedN + 1, n, stack, res); // Explore
            stack.deleteCharAt(stack.length() - 1);       // Unchoose (Pop)
        }
    }
}
