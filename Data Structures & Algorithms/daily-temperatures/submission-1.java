class Solution 
{
    public int[] dailyTemperatures(int[] temp) 
    {
        int[] ans = new int[temp.length]; 
        Deque<Integer> stack = new ArrayDeque<>(); 

        for (int i = 0; i < temp.length; i++) 
        {
            // While the current temperature is warmer than the temperature at the top stack index
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) 
            {
                int previousIndex = stack.pop();
                // The distance between the days is the difference between their indices
                ans[previousIndex] = i - previousIndex;
            }
            // Always push the current day's index onto the stack
            stack.push(i);
        }

        return ans;
    }
}